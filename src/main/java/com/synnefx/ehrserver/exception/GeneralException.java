package com.synnefx.ehrserver.exception;

/**
 * An unclassified, general error. Default code is 500
 */
public class GeneralException extends EhrServerException {
    // initialize and call the base class
    public GeneralException(String message, int code){
        super(message, code);
    }
}
