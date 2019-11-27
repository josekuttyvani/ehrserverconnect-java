package com.synnefx.ehrserver.exception;

import com.synnefx.ehrserver.models.ErrorResponse;

/**
 * Represents a network issue with EHRServer
 */

public class NetworkException extends EhrServerException {

    // initialize EHRServer Network exception
    public NetworkException(String message, String ehrCode, int code) {
        super(message, ehrCode, code);
    }

    public NetworkException(ErrorResponse errorResponse, int code) {
        super(errorResponse.getMessage(), errorResponse.getCode(), code);
    }
}
