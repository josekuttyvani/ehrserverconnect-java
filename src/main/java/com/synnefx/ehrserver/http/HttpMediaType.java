package com.synnefx.ehrserver.http;

/**
 * @author Josekutty
 * 27-11-2019
 */
public enum HttpMediaType {

    JSON("application/json; charset=utf-8"), XML("application/xml; charset=utf-8");

    private final String mediaType;

    HttpMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaType() {
        return mediaType;
    }
}
