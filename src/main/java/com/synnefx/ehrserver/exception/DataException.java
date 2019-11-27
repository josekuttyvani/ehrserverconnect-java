package com.synnefx.ehrserver.exception;

import com.synnefx.ehrserver.models.ErrorResponse;

/**
 * Exceptions raised when invalid request is submitted.
 */

public class DataException extends EhrServerException {

    public DataException(String message, String ehrCode, int code) {
        super(message, ehrCode, code);
    }

    public DataException(ErrorResponse errorResponse, int code) {
        super(errorResponse.getMessage(), errorResponse.getCode(), code);
    }
}

