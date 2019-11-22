package com.synnefx.ehrserver;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Josekutty
 * 20-11-2019
 */
public class ApiRoutes {

    private static String EHR_BASE_URL = "http://localhost:8090/ehr/api/";
    private static String EHR_API_VERSION = "v1";
    public Map<String, String> routes;

    public ApiRoutes() {
        routes = new HashMap<String, String>() {{
            put("api.login", "/login");
            put("organizations", "/organizations");

            put("ehrs", "/ehrs");
            put("ehr", "/ehrs/:ehr_id");
            put("ehr.subject", "/ehrs/subjectUid/:subjectId");

            put("compositions", "/ehrs/:ehr_id/compositions");
            put("compositions.list", "/compositions");
            put("compositions.get", "/compositions/:compositionUid");
            put("compositions.checkout", "/ehrs/:ehr_id/compositions/:compositionUid/checkout");

            put("templates", "/templates");
            put("template", "/templates/:uid");

            put("queries", "/queries");
            put("query", "/queries/:queryId");
            put("query.execute", "/queries/:queryId/execute");


        }};
    }

    public String get(String key) {
        return EHR_BASE_URL + EHR_API_VERSION + routes.get(key);
    }
}
