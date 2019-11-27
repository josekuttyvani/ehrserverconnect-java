package com.synnefx.ehrserver.http;

import com.google.gson.GsonBuilder;
import com.synnefx.ehrserver.EhrServerConnect;
import com.synnefx.ehrserver.exception.*;
import com.synnefx.ehrserver.models.EhrErrorResponse;
import com.synnefx.ehrserver.models.ErrorResponse;
import com.synnefx.ehrserver.utils.Utils;
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


    private boolean isOk(Response response) {
        switch (response.code()) {
            case 200:
            case 201:
            case 202:
                return true;
            default:
                return false;

        }
    }

    public JSONObject handle(Response response) throws IOException, EhrServerException, JSONException {

        LOGGER.debug("Response status is " + response.code());
        LOGGER.debug("Response Content Type is " + response.header("Content-Type"));
        if (isOk(response)) {
            if (response.header("Content-Type").contains("json")) {
                String body = response.body().string();
                JSONObject jsonObject = new JSONObject(body);
                /*if (jsonObject.has("error_type")) {
                    throw handleErrorResponse(jsonObject, response.code());
                }*/
                return jsonObject;
            }
        }
        throw handleErrorResponse(getErrorResponse(response), response.code());
    }


    public String handle(Response response, ResponseType type) throws IOException, EhrServerException, JSONException {
        LOGGER.debug("Response status is " + response.code());
        LOGGER.debug("Response Content Type is " + response.header("Content-Type"));
        if (isOk(response)) {
            String body = response.body().string();
            if (response.header("Content-Type").contains("xml")) {
                //TODO ?
                return body;
            } else if (response.header("Content-Type").contains("json")) {
                //throw handleException(new JSONObject(body), response.code());
                return body;
            }
        }
        throw handleErrorResponse(getErrorResponse(response), response.code());
    }

    private ErrorResponse getErrorResponse(Response response) throws IOException {
        if (response.header("Content-Type").contains("xml")) {
            return Utils.parseXmlErrorResponse(response.body().string());
        } else if (response.header("Content-Type").contains("json")) {
            //throw handleException(new JSONObject(body), response.code());
            GsonBuilder gsonBuilder = new GsonBuilder();
            return gsonBuilder.create().fromJson(String.valueOf(new JSONObject(response.body().string())), EhrErrorResponse.class).getResult();
        }
        return null;
    }


    private EhrServerException handleErrorResponse(ErrorResponse errorResponse, int code) throws JSONException {
        if (null != errorResponse) {
            //switch (errorResponse.getCode()) {
            switch (code) {
                // if there is a token exception, generate a signal to logout the user.
                case 401:
                    if (EhrServerConnect.sessionExpiryHook != null) {
                        EhrServerConnect.sessionExpiryHook.sessionExpired();
                    }
                    return new TokenException(errorResponse, code);
                case 400:
                    return new DataException(errorResponse, code);
                case 500:
                    return new EhrServerException(errorResponse.getMessage(), errorResponse.getCode(), code);
               /* case "InputException":
                    return new InputException(errorResponse, code);
                case "NetworkException":
                    return new NetworkException(errorResponse, code);*/
                case 403:
                    return new PermissionException(errorResponse, code);
                default:
                    return new GeneralException(errorResponse, code);
            }
        }
        return new EhrServerException(errorResponse.getMessage(), errorResponse.getCode(), code);
    }
}
