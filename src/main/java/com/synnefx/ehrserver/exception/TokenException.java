package com.synnefx.ehrserver.exception;

import com.synnefx.ehrserver.models.ErrorResponse;
import org.json.JSONObject;

/**
 * Denotes session is expired.
 */
public class TokenException extends EhrServerException {

    private ErrorResponse errorResponse;

    public TokenException(String message, int code) {
        super(message, code);
        errorResponse= new ErrorResponse();
        //JSONObject jsonObject = new JSONObject(message);
        //errorResponse.setType();
    }
}
