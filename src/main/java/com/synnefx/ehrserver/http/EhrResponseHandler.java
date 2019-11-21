package com.synnefx.ehrserver.http;

import com.synnefx.ehrserver.EhrServerConnect;
import com.synnefx.ehrserver.exception.*;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author Josekutty
 * 20-11-2019
 */
public class EhrResponseHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger("EHRConnect");


    private boolean isOk(Response response) throws IOException, PermissionException, TokenException {
        switch (response.code()){
            case 200:
            case 201:
            case 202:
                return  true;
            case 401:
                throw new PermissionException(response.body().string(),response.code());
            case 403:
                throw new TokenException(response.body().string(),response.code());
            default:
               return false;

        }
    }

    public JSONObject handle(Response response) throws IOException, EhrServerException, JSONException {

        LOGGER.debug("Response status is "+response.code());
        LOGGER.debug("Response Content Type is "+response.header("Content-Type"));
        if (isOk(response)) {
            if (response.header("Content-Type").contains("json")) {
                String body = response.body().string();
                JSONObject jsonObject = new JSONObject(body);
                if(jsonObject.has("error_type")) {
                    throw hendleException(jsonObject, response.code());
                }
                return jsonObject;
            }
        }
        throw new DataException("Unexpected content type received from server: "+ response.header("Content-Type")+" "+response.body().string(), 502);
    }


    public String handle(Response response, String type) throws IOException, EhrServerException, JSONException {
        LOGGER.debug("Response status is "+response.code());
        LOGGER.debug("Response Content Type is "+response.header("Content-Type"));
        if (isOk(response)) {
            String body = response.body().string();
            if (response.header("Content-Type").contains("xml")) {
                //TODO ?
                return body;
            } else if(response.header("Content-Type").contains("json")){
                throw hendleException(new JSONObject(body), response.code());
            }
        }
        throw new DataException("Unexpected content type received from server: "+ response.header("Content-Type")+" "+response.body().string(), 502);
    }


    private EhrServerException hendleException(JSONObject jsonObject, int code) throws JSONException {
        String exception = jsonObject.getString("error_type");

        switch (exception){
            // if there is a token exception, generate a signal to logout the user.
            case "TokenException":
                if(EhrServerConnect.sessionExpiryHook != null) {
                    EhrServerConnect.sessionExpiryHook.sessionExpired();
                }
                return  new TokenException(jsonObject.getString("message"), code);

            case "DataException": return new DataException(jsonObject.getString("message"), code);

            case "GeneralException": return new GeneralException(jsonObject.getString("message"), code);

            case "InputException": return new InputException(jsonObject.getString("message"), code);

            case "NetworkException": return new NetworkException(jsonObject.getString("message"), code);

            case "PermissionException": return new PermissionException(jsonObject.getString("message"), code);

            default: return new EhrServerException(jsonObject.getString("message"), code);
        }
    }

}
