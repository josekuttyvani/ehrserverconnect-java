package com.synnefx.ehrserver.exception;

import com.synnefx.ehrserver.EhrServerConnect;

/**
 * Exceptions raised when invalid request is submitted.
 */

public class DataException extends EhrServerException {

    public DataException(String message, int code){
        super(message, code);
    }
}

