package com.synnefx.ehrserver.exception;

/**
 * This is the base exception class which has a publicly accessible message and code that
 * is received from EHRServer api.
 */

public class EhrServerException extends Throwable {

    // variables
    public String message;
    public String ehrCode;
    public int code;


    // constructor that sets the message
    public EhrServerException(String message) {
        this.message = message;
    }

    // constructor that sets the message and code
    public EhrServerException(String message, String ehrCode, int code) {
        this.ehrCode = ehrCode;
        this.message = message;
        this.code = code;
    }


    @Override
    public String toString() {
        return "EhrServerException{" +
                "message='" + message + '\'' +
                ", ehrCode='" + ehrCode + '\'' +
                ", code=" + code +
                '}';
    }
}
