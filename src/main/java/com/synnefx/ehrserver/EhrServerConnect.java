package com.synnefx.ehrserver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.synnefx.ehrserver.exception.EhrServerException;
import com.synnefx.ehrserver.http.EhrRequestHandler;
import com.synnefx.ehrserver.http.ResponseType;
import com.synnefx.ehrserver.http.SessionExpiryHook;
import com.synnefx.ehrserver.models.*;
import com.synnefx.ehrserver.models.query.EhrQuery;
import com.synnefx.ehrserver.models.query.EhrQueryParameter;
import com.synnefx.ehrserver.utils.NotNull;
import com.synnefx.ehrserver.utils.Nullable;
import com.synnefx.ehrserver.utils.Utils;
import com.synnefx.ehrserver.xsd.ORIGINALVERSION;
import openEHR.v1.template.TemplateDocument;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openehr.am.template.OETParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


    /**
     * Initializes EHRServerConnect SDK with the api key provided for your app.
     *
     */
    public EhrServerConnect() {
        this( null, false);
    }

    /**
     * Initializes EHRServerConnect SDK with the api key provided for your app.
     * @param enableDebugLog is a boolean to enable debug logs
     */
    public EhrServerConnect(boolean enableDebugLog) {
        this( null, enableDebugLog);
    }

    /**
     * Initializes EHRServerConnect SDK with the api key provided for your app.
     *
     * @param userProxy is the user defined proxy. Can be used only if a user chose to use the proxy.
     */
    public EhrServerConnect(Proxy userProxy, boolean enableDebugLog) {
        this.proxy = userProxy;
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

    /**
     * Registers callback for session error.
     *
     * @param hook can be set to get callback when session is expired.
     */
    public void setSessionExpiryHook(SessionExpiryHook hook) {
        sessionExpiryHook = hook;
    }

    /**
     * Returns apiKey of the App.
     *
     * @return String apiKey is returned.
     * @throws NullPointerException if _apiKey is not found.
     */
    public String getApiKey() throws NullPointerException {
        if (apiKey != null)
            return apiKey;
        else
            throw new NullPointerException();
    }


    private void setPageRequest(EhrPageRequest pageRequest, Map<String, Object> params) {
        if (null != pageRequest) {
            params.put("max", pageRequest.getMaxRecords());
            params.put("offSet", pageRequest.getOffset());
        }

    }

    /**
     * Do the token exchange with the `request_token` obtained after the login flow,
     * and retrieve the `access_token` required for all subsequent requests.
     *
     * @return User is the user model which contains user and session details.
     * @throws EhrServerException is thrown for all EHRServer related errors.
     * @throws JSONException      is thrown when there is exception while parsing response.
     * @throws IOException        is thrown when there is connection error.
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


    public List<EhrOrganization> listOrganizations(String apiKey) throws IOException, EhrServerException {
        Map<String, Object> params = new HashMap<>();
        params.put("format", "json");
        String response = ehrRequestHandler.getRequest(routes.get("organizations"), params, ResponseType.JSON, apiKey);
        return Arrays.asList(gson.fromJson(response, EhrOrganization[].class));
    }

    public List<EhrHealthRecord> listHealthRecords(String apiKey, EhrPageRequest pageRequest) throws IOException, EhrServerException {
        Map<String, Object> params = new HashMap<>();
        params.put("format", "json");
        setPageRequest(pageRequest, params);
        JSONObject response = ehrRequestHandler.getRequest(routes.get("ehrs"), params, apiKey);
        return Arrays.asList(gson.fromJson(String.valueOf(response.get("ehrs")), EhrHealthRecord[].class));
    }

    public EhrHealthRecord getHealthRecord(String ehrId, String apiKey) throws IOException, EhrServerException {
        if (StringUtils.isEmpty(ehrId)) {
            throw new IllegalArgumentException("Ehr id expected");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("format", "json");
        JSONObject response = ehrRequestHandler.getRequest(routes.get("ehr").replace(":ehr_id", ehrId), params, apiKey);
        return gson.fromJson(String.valueOf(response), EhrHealthRecord.class);
    }

    public EhrHealthRecord getHealthRecordBySubject(String subjectId, String apiKey) throws IOException, EhrServerException {
        if (StringUtils.isEmpty(subjectId)) {
            throw new IllegalArgumentException("Subject id expected");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("format", "json");
        JSONObject response = ehrRequestHandler.getRequest(routes.get("ehr.subject").replace(":subjectId", subjectId), params, apiKey);
        return gson.fromJson(String.valueOf(response), EhrHealthRecord.class);
    }

    public EhrHealthRecord createHealthRecord(EhrHealthRecord healthRecord, String apiKey) throws IOException, EhrServerException {
        Map<String, Object> params = new HashMap<>();
        params.put("subjectUid", healthRecord.getSubjectUid());
        params.put("format", "json");
        JSONObject response = ehrRequestHandler.postRequest(routes.get("ehrs"), params, apiKey);
        return gson.fromJson(String.valueOf(response), EhrHealthRecord.class);
    }


    public List<Template> listTemplates(String apiKey, EhrPageRequest pageRequest) throws IOException, EhrServerException {
        Map<String, Object> params = new HashMap<>();
        params.put("format", "json");
        setPageRequest(pageRequest, params);
        JSONObject response = ehrRequestHandler.getRequest(routes.get("templates"), params, apiKey);
        return Arrays.asList(gson.fromJson(String.valueOf(response.get("templates")), Template[].class));
    }

    public TemplateDocument getTemplate(String templateUid, String apiKey) throws Exception, EhrServerException {
        if (StringUtils.isEmpty(templateUid)) {
            throw new IllegalArgumentException("Template Id expected");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("format", "xml");
        String response = ehrRequestHandler.getRequest(routes.get("template")
                .replace(":uid", templateUid), params, ResponseType.XML, apiKey);
        //return Arrays.asList(gson.fromJson(String.valueOf(response.get("templates")), Template[].class));
        OETParser oetParser = new OETParser();
        return oetParser.parseTemplate(new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8)));
        //return String.valueOf(response);
    }

    public String createComposition(String composition, String committerName, String ehrId, String apiKey) throws IOException, EhrServerException {
        Map<String, Object> params = new HashMap<>();
        params.put("auditCommitter", committerName);
        params.put("format", "xml");
        return ehrRequestHandler.postRequestForXml(routes.get("compositions").replace(":ehr_id", ehrId),
                composition, params, apiKey);
        //return gson.fromJson(String.valueOf(response), HealthRecord.class);
        //return  String.valueOf(response);
    }

    public String createComposition(ORIGINALVERSION versions, String committerName, String ehrId, String apiKey) throws IOException, EhrServerException {
        Map<String, Object> params = new HashMap<>();
        params.put("auditCommitter", committerName);
        params.put("format", "xml");
        return ehrRequestHandler.postRequestForXml(routes.get("compositions").replace(":ehr_id", ehrId),
                Utils.formatComposionPaylod(versions), params, apiKey);
        //return gson.fromJson(String.valueOf(response), HealthRecord.class);
        // return  String.valueOf(response);
    }

    private List<EhrComposition> listCompositions(Map<String, Object> params, String archetypeId, String apiKey, EhrPageRequest pageRequest) throws IOException, EhrServerException {
        if (StringUtils.isNotEmpty(archetypeId)) {
            params.put("archetypeId", archetypeId);
        }

        params.put("format", "json");
        setPageRequest(pageRequest, params);
        JSONObject response = ehrRequestHandler.getRequest(routes.get("compositions.list"),
                params, apiKey);
        Object result = response.get("result");
        if (result instanceof JSONObject) {
            //Must be JSONArray
            return Collections.emptyList();
        }
        return Arrays.asList(gson.fromJson(String.valueOf(result), EhrComposition[].class));
    }

    /**
     * Get list of composition for a given EHR
     *
     * @param ehrId
     * @param archetypeId - Optional
     * @param apiKey
     * @param pageRequest
     * @return
     * @throws IOException
     * @throws EhrServerException
     */
    public List<EhrComposition> listCompositionByEhrId(@NotNull String ehrId, @Nullable String archetypeId, String apiKey, EhrPageRequest pageRequest) throws IOException, EhrServerException {
        if (StringUtils.isEmpty(ehrId)) {
            throw new IllegalArgumentException("Ehr Id expected");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("ehrUid", ehrId);
        return listCompositions(params, archetypeId, apiKey, pageRequest);
    }

    /**
     * Get list of composition for a given EHR
     * Caution: Aleways ends up wuth error :
     * {"result":{"type":"AR",
     * "message":"EHR [$8d786d63-73d5-47bd-9ac4-7f6aec3be646$] doesn't belong to organization $e9d13294-bce7-44e7-9635-8e906da0c914$",
     * "code":"EHRSERVER::API::RESPONSE_CODES::462"}}
     *
     * @param subjectId
     * @param archetypeId - Optional
     * @param apiKey
     * @param pageRequest
     * @return
     * @throws IOException
     * @throws EhrServerException
     */
    @Deprecated
    public List<EhrComposition> listCompositionBySubjectId(@NotNull String subjectId, @Nullable String archetypeId, String apiKey, EhrPageRequest pageRequest) throws IOException, EhrServerException {
        if (StringUtils.isEmpty(subjectId)) {
            throw new IllegalArgumentException("Subject Id expected");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("subjectId", subjectId);

        return listCompositions(params, archetypeId, apiKey, pageRequest);
    }

    /**
     * Get an XML form of a given Composition
     *
     * @param compositionUid
     * @param apiKey
     * @return
     * @throws IOException
     * @throws EhrServerException
     */
    public String getComposition(@NotNull String compositionUid, String apiKey) throws IOException, EhrServerException {
        if (StringUtils.isEmpty(compositionUid)) {
            throw new IllegalArgumentException("Composition Id expected");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("format", "xml");
        return ehrRequestHandler.getRequest(routes.get("compositions.get")
                        .replace(":compositionUid",compositionUid),
                params, ResponseType.XML, apiKey);
        //return gson.fromJson(String.valueOf(response.get("result")), EhrComposition[].class);
    }

    /**
     * Checkout a given composition
     *
     * @param compositionUid
     * @param apiKey
     * @return
     * @throws IOException
     * @throws EhrServerException
     */
    public String checkoutComposition(String ehrId, String compositionUid, String apiKey) throws IOException, EhrServerException {
        if (StringUtils.isEmpty(ehrId)
                || StringUtils.isEmpty(compositionUid)) {
            throw new IllegalArgumentException("Ehr Id and Composition Id are expected");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("format", "xml");
        return ehrRequestHandler.getRequest(routes.get("compositions.checkout")
                        .replace(":ehr_id", ehrId)
                        .replace(":compositionUid", compositionUid),
                params, ResponseType.XML, apiKey);
        //return gson.fromJson(String.valueOf(response.get("result")), EhrComposition[].class);
    }


    /**
     * List all stored queries
     *
     * @param apiKey
     * @param pageRequest
     * @return
     * @throws IOException
     * @throws EhrServerException
     */
    public List<EhrQuery> listQueries(String apiKey, EhrPageRequest pageRequest) throws IOException, EhrServerException {

        Map<String, Object> params = new HashMap<>();
        params.put("format", "json");
        setPageRequest(pageRequest, params);
        JSONObject response = ehrRequestHandler.getRequest(routes.get("queries"),
                params, apiKey);
        Object queryList = response.get("queries");
        if (queryList instanceof JSONObject) {
            //When query list is empty returned json is JSONObject not JSONArray.
            return Collections.emptyList();
        }
        return Arrays.asList(gson.fromJson(String.valueOf(queryList), EhrQuery[].class));
    }


    /**
     * Get the details od a given query
     *
     * @param queryId
     * @param apiKey
     * @return
     * @throws IOException
     * @throws EhrServerException
     */
    public EhrQuery getQuery(String queryId, String apiKey) throws IOException, EhrServerException {
        if (StringUtils.isEmpty(queryId)) {
            throw new IllegalArgumentException("Query Id expected");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("format", "json");
        return gson.fromJson(String.valueOf(ehrRequestHandler.getRequest(routes.get("query")
                        .replace(":queryId", queryId),
                params, apiKey)), EhrQuery.class);
    }


    /**
     * Get the details od a given query
     *
     * @param queryId
     * @param apiKey
     * @return
     * @throws IOException
     * @throws EhrServerException
     */
    public String runQuery(String queryId, EhrQueryParameter queryParameter, String apiKey) throws IOException, EhrServerException {
        if (StringUtils.isEmpty(queryId)) {
            throw new IllegalArgumentException("Query Id expected");
        }
        Map<String, Object> params;
        if (null != queryParameter) {
            params = queryParameter.getRequestParameters();
        } else {
            params = new HashMap<>();
            params.put("format", "json");
        }
        return String.valueOf(ehrRequestHandler.getRequest(routes.get("query.execute").replace(":queryId", queryId),
                params, ResponseType.JSON, apiKey));
    }

}
