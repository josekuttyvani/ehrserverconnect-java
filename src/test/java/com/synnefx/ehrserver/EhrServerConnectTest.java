package com.synnefx.ehrserver;

import com.synnefx.ehrserver.exception.DataException;
import com.synnefx.ehrserver.exception.EhrServerException;
import com.synnefx.ehrserver.exception.PermissionException;
import com.synnefx.ehrserver.models.HealthRecord;
import com.synnefx.ehrserver.models.Organization;
import com.synnefx.ehrserver.models.Template;
import openEHR.v1.template.TemplateDocument;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author Josekutty
 * 20-11-2019
 */
public class EhrServerConnectTest {

    private String apiToken = Contants.API_TOKEN;

    private String ehrId = Contants.EHR_ID;

    private  EhrServerConnect ehrServerConnect;

    private String getToken() throws EhrServerException, IOException {
       return ehrServerConnect.generateAccessToken("admin", "admin", "123456");
    }

    @Before
    public void setUp() {
        ehrServerConnect = new EhrServerConnect(apiToken, true);
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
        List<Organization> organizations = ehrServerConnect.listOrganizations(apiToken);
        assertNotNull("Organizations can not be empty", organizations);
        assertNotEquals("Organizations can not be empty", 0, organizations.size());
    }

    @Test
    public void testHealthRecordListing() throws IOException, EhrServerException {
        List<HealthRecord> healthRecords = ehrServerConnect.listHealthRecords(apiToken);
        assertNotNull("HealthRecords can not be empty", healthRecords);
        assertNotEquals("HealthRecords can not be empty", 0, healthRecords.size());
    }

    @Test
    public void testHealthRecordFetch() throws IOException, EhrServerException {
        HealthRecord healthRecord = ehrServerConnect.getHealthRecord(ehrId, apiToken);
        assertNotNull("HealthRecord can not be null", healthRecord);
        assertEquals("HealthRecord fetched is wrong one!", "aec8d8b9-39dc-432d-8601-a060da6136f6", healthRecord.getSubjectUid());
    }

    @Test(expected = DataException.class)
    public void testHealthRecordNotFound() throws IOException, EhrServerException {
        HealthRecord healthRecord = ehrServerConnect.getHealthRecord("dummy ehr id", apiToken);
        assertNull("HealthRecord must be null", healthRecord);
        //assertEquals("HealthRecord fetched is wrong one!", "aec8d8b9-39dc-432d-8601-a060da6136f6", healthRecord.getSubjectUid());
    }

    @Test
    public void testNewHealthRecord() throws IOException, EhrServerException {
        HealthRecord healthRecord = new HealthRecord();
        String mrdNumber = UUID.randomUUID().toString();
        healthRecord.setSubjectUid(mrdNumber);
        healthRecord = ehrServerConnect.createHealthRecord(healthRecord, apiToken);
        assertNotNull("HealthRecord can not be null", healthRecord);
        assertEquals("HealthRecord fetched is wrong one!", mrdNumber, healthRecord.getSubjectUid());
    }

    @Test
    public void testTemplateListing() throws IOException, EhrServerException {
        List<Template> templates = ehrServerConnect.listTemplates(apiToken);
        assertNotNull("Templates can not be empty", templates);
        assertNotEquals("Templates can not be empty", 0, templates.size());
    }

    @Test
    public void testTemplateFetch() throws Exception, EhrServerException {
        String templateId = "0f7d60f4-4e67-4325-9f8e-f4a0028ec6c9";

        TemplateDocument response = ehrServerConnect.getTemplate(templateId, apiToken);

        System.out.println(response);
        assertNotNull("Template Details can't be null",response);
    }

    @Test
    public void testNewComposition() throws IOException, EhrServerException {
        String payLoad = "";
        String response = ehrServerConnect.createComposition(payLoad, "Josekutty", ehrId,  apiToken);
        assertNotNull("Create composition response can't be null",response);
    }
}
