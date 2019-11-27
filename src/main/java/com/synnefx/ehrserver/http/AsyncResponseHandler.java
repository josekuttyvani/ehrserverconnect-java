package com.synnefx.ehrserver.http;

/**
 * @author Josekutty
 * 27-11-2019
 */
public interface AsyncResponseHandler {

    void onError(String code, String message);

    void onSuccess();
}
