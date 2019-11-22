package com.synnefx.ehrserver;

import com.synnefx.ehrserver.exception.EhrServerException;
import com.synnefx.ehrserver.models.EhrComposition;
import com.synnefx.ehrserver.models.EhrPageRequest;
import com.synnefx.ehrserver.utils.Utils;
import com.synnefx.ehrserver.xsd.ORIGINALVERSION;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Josekutty
 * 21-11-2019
 */
public class CompositionTest {

    private String apiToken = Constants.API_TOKEN;

    private String ehrId = Constants.EHR_ID;
    private EhrServerConnect ehrServerConnect;

    private EhrPageRequest pageRequest;

    private String getToken() throws EhrServerException, IOException {
        return ehrServerConnect.generateAccessToken("admin", "admin", "123456");
    }

    @Before
    public void setUp() {
        ehrServerConnect = new EhrServerConnect(apiToken, true);
        pageRequest = new EhrPageRequest();
    }


    @Test
    public void testXMLParsing() throws JAXBException {
        ORIGINALVERSION versions = Utils.initDummyComposition();
        assertNotNull("Version can't be null", versions);
    }

    @Test
    public void testXMLToString() throws JAXBException {
        ORIGINALVERSION versions = Utils.initDummyComposition();
        updateData(versions);
        assertNotNull("Version can't be null", versions);
        String xml = Utils.xmlToString(versions);
        assertNotNull("XML can't be null", xml);
        System.out.println(xml);
    }

    @Test
    public void testFileCommit() throws JAXBException, IOException, EhrServerException {
        InputStream xmlFile = Utils.class.getResourceAsStream("/xsd/Physical Activity Composition Request.xml");
        assertNotNull("XML can't be null", xmlFile);
        StringBuilder textBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader
                (xmlFile, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
        }


        System.out.println(textBuilder.toString());
        String response = ehrServerConnect.createComposition(textBuilder.toString(), "Josekutty T", ehrId, apiToken);
        assertNotNull("Commit response can't be null", response);
    }


    @Test
    public void testCompositionCommit() throws IOException, EhrServerException, JAXBException {
        ORIGINALVERSION versions = Utils.initDummyComposition();
        updateData(versions);
        String response = ehrServerConnect.createComposition(versions, "Josekutty T", ehrId, apiToken);
        assertNotNull("Commit response can't be null", response);
    }

    private void updateData(ORIGINALVERSION version) {
        /*
        for(VersionType version : versions.getVersion()){ */
        version.getUid().setValue(UUID.randomUUID().toString());
        version.getContribution().getId().setValue(UUID.randomUUID().toString());
        version.getCommitAudit().getCommitter().getExternalRef().getId().setValue(UUID.randomUUID().toString());
        version.getCommitAudit().getTimeCommitted().setValue(LocalDateTime.now().toString());

        version.getUid().setValue(UUID.randomUUID().toString());
        //version.getData() //.getExternalRef().setId(UUID.randomUUID().toString());

        // version.getData().getContext().setStartTime(LocalDateTime.now().toString());

        //version.getData().getContent().getData().setOrigin(LocalDateTime.now().toString());

        //version.getData().getContent().getData().getEvents().setTime(LocalDateTime.now().toString());
        // }

    }


    @Test
    public void testListAllCompositions() throws IOException, EhrServerException {
        List<EhrComposition> ehrCompositions = ehrServerConnect.listCompositionByEhrId(Constants.EHR_ID, null, apiToken, pageRequest);
        assertNotNull("Compositions can not be empty", ehrCompositions);
        assertNotEquals("Compositions can not be empty", 0, ehrCompositions.size());
    }

    @Test
    public void testListAllCompositions_by_SubjectId() throws IOException, EhrServerException {
        List<EhrComposition> ehrCompositions = ehrServerConnect.listCompositionBySubjectId(Constants.SUBJECT_ID, null, apiToken, pageRequest);
        assertNotNull("Compositions can not be empty", ehrCompositions);
        assertNotEquals("Compositions can not be empty", 0, ehrCompositions.size());
    }

    @Test
    public void testListCompositionsByArchetype() throws IOException, EhrServerException {
        List<EhrComposition> ehrCompositions = ehrServerConnect.listCompositionByEhrId(Constants.EHR_ID, "openEHR-EHR-COMPOSITION.physical_activity_document.v1", apiToken, pageRequest);
        assertNotNull("Compositions can not be empty", ehrCompositions);
        assertNotEquals("Compositions can not be empty", 0, ehrCompositions.size());
    }


    @Test
    public void testGetComposition() throws IOException, EhrServerException {
        String result = ehrServerConnect.getComposition("1913b811-f501-44c0-844e-e2d15t108800", apiToken);
        assertNotNull("Composition can not be null", result);
    }

    @Test
    public void testCheckout() throws IOException, EhrServerException {
        String result = ehrServerConnect.checkoutComposition(Constants.EHR_ID, "1913b811-f501-44c0-844e-e2d15t108800", apiToken);
        assertNotNull("Checkout response can not be null", result);
    }

}
