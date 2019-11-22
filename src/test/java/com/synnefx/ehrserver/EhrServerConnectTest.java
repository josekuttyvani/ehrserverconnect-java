package com.synnefx.ehrserver;

import com.synnefx.ehrserver.exception.DataException;
import com.synnefx.ehrserver.exception.EhrServerException;
import com.synnefx.ehrserver.exception.PermissionException;
import com.synnefx.ehrserver.models.EhrHealthRecord;
import com.synnefx.ehrserver.models.EhrOrganization;
import com.synnefx.ehrserver.models.EhrPageRequest;
import com.synnefx.ehrserver.models.Template;
import openEHR.v1.template.TemplateDocument;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author Josekutty
 * 20-11-2019
 */
public class EhrServerConnectTest {

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
    public void testLoginSuccess() throws EhrServerException, IOException {
        getToken();
    }

    @Test(expected = PermissionException.class)
    public void testLoginFail() throws EhrServerException, IOException {
        ehrServerConnect.generateAccessToken("admin", "455", "123456");
    }

    @Test
    public void testOrganizationListing() throws IOException, EhrServerException {
        List<EhrOrganization> organizations = ehrServerConnect.listOrganizations(apiToken);
        assertNotNull("Organizations can not be empty", organizations);
        assertNotEquals("Organizations can not be empty", 0, organizations.size());
    }

    @Test
    public void testHealthRecordListing() throws IOException, EhrServerException {
        List<EhrHealthRecord> healthRecords = ehrServerConnect.listHealthRecords(apiToken, pageRequest);
        assertNotNull("HealthRecords can not be empty", healthRecords);
        assertNotEquals("HealthRecords can not be empty", 0, healthRecords.size());
    }

    @Test
    public void testHealthRecordFetch() throws IOException, EhrServerException {
        EhrHealthRecord healthRecord = ehrServerConnect.getHealthRecordBySubject(Constants.SUBJECT_ID, apiToken);
        assertNotNull("HealthRecord can not be null", healthRecord);
        assertEquals("HealthRecord fetched is wrong one!", Constants.SUBJECT_ID, healthRecord.getSubjectUid());
    }


    @Test
    public void testHealthRecordFetch_by_SubjectId() throws Exception, EhrServerException {
        EhrHealthRecord healthRecord = ehrServerConnect.getHealthRecord(ehrId, apiToken);
        assertNotNull("HealthRecord can not be null", healthRecord);
        assertEquals("HealthRecord fetched is wrong one!", Constants.SUBJECT_ID, healthRecord.getSubjectUid());
    }

    @Test(expected = DataException.class)
    public void testHealthRecordNotFound() throws IOException, EhrServerException {
        EhrHealthRecord healthRecord = ehrServerConnect.getHealthRecord("dummy ehr id", apiToken);
        assertNull("HealthRecord must be null", healthRecord);
        //assertEquals("HealthRecord fetched is wrong one!", "aec8d8b9-39dc-432d-8601-a060da6136f6", healthRecord.getSubjectUid());
    }

    @Test
    public void testNewHealthRecord() throws IOException, EhrServerException {
        EhrHealthRecord healthRecord = new EhrHealthRecord();
        String mrdNumber = UUID.randomUUID().toString();
        healthRecord.setSubjectUid(mrdNumber);
        healthRecord = ehrServerConnect.createHealthRecord(healthRecord, apiToken);
        assertNotNull("HealthRecord can not be null", healthRecord);
        assertEquals("HealthRecord fetched is wrong one!", mrdNumber, healthRecord.getSubjectUid());
    }

    @Test
    public void testTemplateListing() throws IOException, EhrServerException {
        List<Template> templates = ehrServerConnect.listTemplates(apiToken, pageRequest);
        assertNotNull("Templates can not be empty", templates);
        assertNotEquals("Templates can not be empty", 0, templates.size());
    }

    @Test
    public void testTemplateFetch() throws Exception, EhrServerException {
        TemplateDocument response = ehrServerConnect.getTemplate(Constants.TEMPLATE_ID, apiToken);

        System.out.println(response);
        assertNotNull("Template Details can't be null", response);
    }

    @Test
    public void testNewComposition() throws IOException, EhrServerException {
        String payLoad = "";
        String response = ehrServerConnect.createComposition(payLoad, "Josekutty", ehrId, apiToken);
        assertNotNull("Create composition response can't be null", response);
    }
}
