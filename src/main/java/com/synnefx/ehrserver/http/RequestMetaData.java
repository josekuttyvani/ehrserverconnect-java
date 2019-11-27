package com.synnefx.ehrserver.http;

/**
 * @author Josekutty
 * 27-11-2019
 */
public class RequestMetaData {

    private final String url;

    private final String token;

    private HttpMediaType mediaType = HttpMediaType.JSON;

    public RequestMetaData(String url, String token) {
        if (null == url || null == token) {
            throw new IllegalArgumentException("Valid url and token expected");
        }
        this.url = url;
        this.token = token;
    }

    public RequestMetaData(String url, String token, HttpMediaType mediaType) {
        this(url, token);
        this.setMediaType(mediaType);
    }

    public static RequestMetaData getInstance(String url, String apiToken) {
        return new RequestMetaData(url, apiToken);
    }

    public String getUrl() {
        return url;
    }


    public String getToken() {
        return token;
    }

    public HttpMediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(HttpMediaType mediaType) {
        this.mediaType = mediaType;
    }
}
