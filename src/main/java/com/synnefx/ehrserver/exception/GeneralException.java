package com.synnefx.ehrserver.exception;

import com.synnefx.ehrserver.models.ErrorResponse;

/**
 * An unclassified, general error. Default code is 500
 */
public class GeneralException extends EhrServerException {
    // initialize and call the base class
    public GeneralException(String message, String ehrCode, int code) {
        super(message, ehrCode, code);
    }

    public GeneralException(ErrorResponse errorResponse, int code) {
        super(errorResponse.getMessage(), errorResponse.getCode(), code);
    }
}
