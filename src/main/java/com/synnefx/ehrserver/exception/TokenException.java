package com.synnefx.ehrserver.exception;

import com.synnefx.ehrserver.models.ErrorResponse;

/**
 * Denotes session is expired.
 */
public class TokenException extends EhrServerException {


    public TokenException(String message, String ehrCode, int code) {
        super(message, ehrCode, code);
    }

    public TokenException(ErrorResponse errorResponse, int code) {
        super(errorResponse.getMessage(), errorResponse.getCode(), code);
    }

}
