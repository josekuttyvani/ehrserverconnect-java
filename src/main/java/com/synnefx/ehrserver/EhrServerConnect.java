package com.synnefx.ehrserver;

import com.google.gson.*;
import com.synnefx.ehrserver.exception.EhrServerException;
import com.synnefx.ehrserver.http.EhrRequestHandler;
import com.synnefx.ehrserver.http.SessionExpiryHook;
import com.synnefx.ehrserver.models.HealthRecord;
import com.synnefx.ehrserver.models.Organization;
import com.synnefx.ehrserver.models.Template;
import com.synnefx.ehrserver.xml.VersionsType;
import openEHR.v1.template.TemplateDocument;
import org.json.JSONException;
import org.json.JSONObject;
import org.openehr.am.template.OETParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.Proxy;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Josekutty
 * 20-11-2019
 */
public class EhrServerConnect {

    private static final Logger LOGGER = LoggerFactory.getLogger("EHRConnect");

    public static SessionExpiryHook sessionExpiryHook = null;
    public static boolean ENABLE_LOGGING = false;

    private Proxy proxy = null;
    private String apiKey;
    private ApiRoutes routes = new ApiRoutes();
    private Gson gson;

    private EhrRequestHandler ehrRequestHandler;


    /** Initializes EHRServerConnect SDK with the api key provided for your app.
     * @param apiKey is the api key provided after creating new Organization on developers console.
     */
    public EhrServerConnect(String apiKey){
        this(apiKey, null, false);
    }

    /** Initializes EHRServerConnect SDK with the api key provided for your app.
     * @param apiKey is the api key provided after creating new Organization on developers console.
     * @param enableDebugLog is a boolean to enable debug logs
     */
    public EhrServerConnect(String apiKey, boolean enableDebugLog){
        this(apiKey, null, enableDebugLog);
    }

    /** Initializes EHRServerConnect SDK with the api key provided for your app.
     * @param apiKey is the api key provided after creating new Organization on developers console.
     * @param userProxy is the user defined proxy. Can be used only if a user chose to use the proxy.
     */
    public EhrServerConnect(String apiKey, Proxy userProxy, boolean enableDebugLog) {
        this.proxy = userProxy;
        this.apiKey = apiKey;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (jsonElement, type, jsonDeserializationContext) -> {
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return format.parse(jsonElement.getAsString());
            } catch (ParseException e) {
                return null;
            }
        });
        gson = gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        ENABLE_LOGGING = enableDebugLog;
        ehrRequestHandler = new EhrRequestHandler(proxy);
    }

    /** Registers callback for session error.
     * @param hook can be set to get callback when session is expired.
     * */
    public void setSessionExpiryHook(SessionExpiryHook hook){
        sessionExpiryHook = hook;
    }

    /**
     *  Returns apiKey of the App.
     * @return  String apiKey is returned.
     * @throws NullPointerException if _apiKey is not found.
     */
    public String getApiKey() throws NullPointerException{
        if (apiKey != null)
            return apiKey;
        else
            throw new NullPointerException();
    }


    /**
     * Do the token exchange with the `request_token` obtained after the login flow,
     * and retrieve the `access_token` required for all subsequent requests.
     * @return User is the user model which contains user and session details.
     * @throws EhrServerException is thrown for all EHRServer related errors.
     * @throws JSONException is thrown when there is exception while parsing response.
     * @throws IOException is thrown when there is connection error.
     */
    public String generateAccessToken(String userName, String password, String organization) throws EhrServerException, JSONException, IOException {

        // Create the checksum needed for authentication.

        // Create JSON params object needed to be sent to api.
        Map<String, Object> params = new HashMap<>();
        params.put("username", userName);
        params.put("password", password);
        params.put("organization", organization);
        params.put("format", "json");
        JSONObject jsonObject = ehrRequestHandler.postRequest(routes.get("api.login"), params, null);
        return jsonObject.getString("token");
    }


    public List<Organization> listOrganizations(String apiKey) throws IOException, EhrServerException {
        Map<String, Object> params = new HashMap<>();
        params.put("format", "json");
        JSONObject response = ehrRequestHandler.getRequest(routes.get("organizations"), params, apiKey);
        return Arrays.asList(gson.fromJson(response.toString(), Organization[].class));
    }

    public List<HealthRecord> listHealthRecords(String apiKey) throws IOException, EhrServerException {
        Map<String, Object> params = new HashMap<>();
        params.put("format", "json");
        JSONObject response = ehrRequestHandler.getRequest(routes.get("ehrs"), params, apiKey);
        return Arrays.asList(gson.fromJson(String.valueOf(response.get("ehrs")), HealthRecord[].class));
    }

    public HealthRecord getHealthRecord(String ehrId, String apiKey) throws IOException, EhrServerException {
        Map<String, Object> params = new HashMap<>();
        params.put("format", "json");
        JSONObject response = ehrRequestHandler.getRequest(routes.get("ehr").replace(":ehr_id", ehrId), params, apiKey);
        return gson.fromJson(String.valueOf(response), HealthRecord.class);
    }

    public HealthRecord createHealthRecord(HealthRecord healthRecord, String apiKey) throws IOException, EhrServerException {
        Map<String, Object> params = new HashMap<>();
        params.put("subjectUid",healthRecord.getSubjectUid());
        params.put("format", "json");
        JSONObject response = ehrRequestHandler.postRequest(routes.get("ehrs"), params, apiKey);
        return gson.fromJson(String.valueOf(response), HealthRecord.class);
    }


    public List<Template> listTemplates(String apiKey) throws IOException, EhrServerException {
        Map<String, Object> params = new HashMap<>();
        params.put("format", "json");
        JSONObject response = ehrRequestHandler.getRequest(routes.get("templates"), params, apiKey);
        return Arrays.asList(gson.fromJson(String.valueOf(response.get("templates")), Template[].class));
    }

    public TemplateDocument getTemplate(String templateUid, String apiKey) throws Exception, EhrServerException {
        Map<String, Object> params = new HashMap<>();
        params.put("format", "xml");
        String response = ehrRequestHandler.getXmlRequest(routes.get("template")
                        .replace(":uid", templateUid), params, apiKey);
        //return Arrays.asList(gson.fromJson(String.valueOf(response.get("templates")), Template[].class));
        OETParser oetParser = new OETParser();
        return oetParser.parseTemplate(new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8)));
        //return String.valueOf(response);
    }

    public String createComposition(String composition, String committerName, String ehrId, String apiKey) throws IOException, EhrServerException {
        Map<String, Object> params = new HashMap<>();
        params.put("auditCommitter", committerName);
        params.put("format", "xml");
        JSONObject response = ehrRequestHandler.postRequest(routes.get("compositions").replace(":ehr_id", ehrId),
                composition,params, apiKey);
        //return gson.fromJson(String.valueOf(response), HealthRecord.class);
        return  String.valueOf(response);
    }

    public String createComposition(VersionsType versions, String committerName, String ehrId, String apiKey) throws IOException, EhrServerException {
        Map<String, Object> params = new HashMap<>();
        params.put("auditCommitter", committerName);
        params.put("format", "xml");
        JSONObject response = ehrRequestHandler.postRequest(routes.get("compositions").replace(":ehr_id", ehrId),
                Utils.xmlToString(versions),params, apiKey);
        //return gson.fromJson(String.valueOf(response), HealthRecord.class);
        return  String.valueOf(response);
    }
}
