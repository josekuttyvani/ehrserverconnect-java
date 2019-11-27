package com.synnefx.ehrserver;

import com.synnefx.ehrserver.exception.EhrServerException;
import com.synnefx.ehrserver.http.AsyncResponseHandler;
import com.synnefx.ehrserver.models.EhrComposition;
import com.synnefx.ehrserver.models.EhrPageRequest;
import com.synnefx.ehrserver.utils.Utils;
import com.synnefx.ehrserver.utils.XMLParser;
import org.junit.Before;
import org.junit.Test;
import org.openehr.schemas.v1.COMPOSITION;
import org.openehr.schemas.v1.ORIGINALVERSION;
import org.openehr.schemas.v1.VersionDocument;

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
        ehrServerConnect = new EhrServerConnect(true);
        pageRequest = new EhrPageRequest();
    }


    @Test
    public void testXMLParsing() {
        VersionDocument versionDocument = Utils.initComposition(Constants.COMPOSITION_FILE_NAME);
        assertNotNull("Version Document can't be null", versionDocument);
        assertNotNull("Version  can't be null", versionDocument.getVersion());
    }


    @Test
    public void testXMLToString_libs() {
        VersionDocument versionDocument = Utils.initComposition(Constants.COMPOSITION_FILE_NAME);
        org.openehr.schemas.v1.ORIGINALVERSION version = (org.openehr.schemas.v1.ORIGINALVERSION) versionDocument.getVersion();
        updateData(versionDocument);
        assertNotNull("Version can't be null", version);
        //String xml = Utils.xmlToString(version);
        //assertNotNull("XML can't be null", xml);
        System.out.println(version.getClass());
        System.out.println(version instanceof org.openehr.schemas.v1.ORIGINALVERSION);
        System.out.println(version.getData().getClass());
        String xml = XMLParser.unmarshall(versionDocument);
        assertNotNull("XML can't be null", xml);
        System.out.println(xml);
    }

    @Test
    public void testParseXmlFromFile() {
        VersionDocument versionDocument = Utils.initComposition(Constants.COMPOSITION_FILE_NAME);
        updateData((ORIGINALVERSION) versionDocument.getVersion());
        assertNotNull("Version can't be null", versionDocument);
        String xml = Utils.formatCompositionPaylod(versionDocument);
        assertNotNull("XML can't be null", xml);
        System.out.println(xml);
    }

    @Deprecated
    @Test
    public void testFileCommit() throws IOException, EhrServerException {
        InputStream xmlFile = Utils.class.getResourceAsStream("/xml/" + Constants.COMPOSITION_FILE_NAME);
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
        VersionDocument versionDocument = Utils.initComposition(Constants.COMPOSITION_FILE_NAME);
        updateData(versionDocument);
        String response = ehrServerConnect.createComposition(versionDocument, "Josekutty T", ehrId, apiToken);
        assertNotNull("Commit response can't be null", response);
    }

    @Test
    public void testCompositionCommit_apacheXml() throws IOException, EhrServerException {
        VersionDocument versionDocument = Utils.initComposition(Constants.COMPOSITION_FILE_NAME);
        org.openehr.schemas.v1.ORIGINALVERSION version = (org.openehr.schemas.v1.ORIGINALVERSION) versionDocument.getVersion();
        assertNotNull("Version can't be null", version);
        updateData(version);
        String xml = XMLParser.unmarshall(versionDocument);
        assertNotNull("XML can't be null", xml);
        String response = ehrServerConnect.createComposition(Utils.formatCompositionPaylod(versionDocument), "Josekutty T", ehrId, apiToken);
        assertNotNull("Commit response can't be null", response);
    }

    @Test
    public void testCompositionCommit_async() throws IOException, EhrServerException, JAXBException {
        VersionDocument version = Utils.initComposition(Constants.COMPOSITION_FILE_NAME);
        updateData(version);
        ehrServerConnect.sendComposition(version, "Josekutty T", ehrId, apiToken, new AsyncResponseHandler() {
            @Override
            public void onError(String code, String message) {
                assertNotNull("Error message can't be null", message);
            }

            @Override
            public void onSuccess() {
                //assertNotNull("Error message can't be null", message);
            }
        });
    }

    private void updateData(VersionDocument versionDocument) {
        if (null != versionDocument && null != versionDocument.getVersion()) {
            updateData((ORIGINALVERSION) versionDocument.getVersion());
        }
    }


    private void updateData(org.openehr.schemas.v1.ORIGINALVERSION version) {
        //version.getUid().setValue(UUID.randomUUID().toString());
        version.getContribution().getId().setValue(UUID.randomUUID().toString());
        version.getCommitAudit().getCommitter().getExternalRef().getId().setValue(UUID.randomUUID().toString());
        version.getCommitAudit().getTimeCommitted().setValue(LocalDateTime.now().toString());

        if (version.getData() instanceof COMPOSITION) {
            COMPOSITION composition = (COMPOSITION) version.getData();
            composition.getComposer().getExternalRef().getId().setValue(UUID.randomUUID().toString());
            composition.getContext().getStartTime().setValue(LocalDateTime.now().toString());
        }
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
        List<EhrComposition> ehrCompositions = ehrServerConnect.listCompositionByEhrId(Constants.EHR_ID, Constants.ARCHETYPE_ID, apiToken, pageRequest);
        assertNotNull("Compositions can not be empty", ehrCompositions);
        assertNotEquals("Compositions can not be empty", 0, ehrCompositions.size());
    }


    @Test
    public void testGetComposition() throws IOException, EhrServerException {
        String result = ehrServerConnect.getComposition(Constants.COMPOSITION_UID, apiToken);
        assertNotNull("Composition can not be null", result);
    }

    @Test
    public void testCheckout() throws IOException, EhrServerException {
        String result = ehrServerConnect.checkoutComposition(Constants.EHR_ID, Constants.COMPOSITION_UID, apiToken);
        assertNotNull("Checkout response can not be null", result);
    }

}
