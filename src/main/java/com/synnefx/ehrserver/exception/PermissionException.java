package com.synnefx.ehrserver.exception;

/**
 * Represents permission denied exceptions for certain calls.
 * Default code is 403
 */
public class PermissionException extends EhrServerException {
    public PermissionException(String message, int code){
        super(message, code);
    }
}
