package com.synnefx.ehrserver.http;

/**
 * @author Josekutty
 * 22-11-2019
 */
public enum ResponseType {

    JSON("json"), XML("xml");

    private final String code;

    ResponseType(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}

