package com.synnefx.ehrserver.exception;

/**
 * Represents a network issue with EHRServer
 */

public class NetworkException extends EhrServerException {

    // initialize EHRServer Network exception
    public NetworkException(String message, int code){
        super(message, code);
    }
}
