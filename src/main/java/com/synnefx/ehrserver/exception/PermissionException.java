package com.synnefx.ehrserver.exception;

import com.synnefx.ehrserver.models.ErrorResponse;

/**
 * Represents permission denied exceptions for certain calls.
 * Default code is 403
 */
public class PermissionException extends EhrServerException {
    public PermissionException(String message, String ehrCode, int code) {
        super(message, ehrCode, code);
    }

    public PermissionException(ErrorResponse errorResponse, int code) {
        super(errorResponse.getMessage(), errorResponse.getCode(), code);
    }
}
