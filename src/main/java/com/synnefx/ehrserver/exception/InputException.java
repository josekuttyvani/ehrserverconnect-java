package com.synnefx.ehrserver.exception;

import com.synnefx.ehrserver.models.ErrorResponse;

/**
 * Represents user input errors such as missing and invalid parameters.
 * Default code is 400.
 */
public class InputException extends EhrServerException {
    // initialize and call base exception constructor
    public InputException(String message, String ehrCode, int code) {
        super(message, ehrCode, code);
    }

    public InputException(ErrorResponse errorResponse, int code) {
        super(errorResponse.getMessage(), errorResponse.getCode(), code);
    }
}

