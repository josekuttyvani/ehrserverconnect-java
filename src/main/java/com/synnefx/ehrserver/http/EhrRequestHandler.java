package com.synnefx.ehrserver.http;

import com.synnefx.ehrserver.EhrServerConnect;
import com.synnefx.ehrserver.exception.EhrServerException;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Proxy;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Josekutty
 * 20-11-2019
 */
public class EhrRequestHandler {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger("EHRConnect");
    public static boolean ENABLE_LOGGING = false;
    private OkHttpClient client;
    private String USER_AGENT = "ehrserverconnect/1.0.0";


    /**
     * Initialize request handler.
     *
     * @param proxy to be set for making requests.
     */
    public EhrRequestHandler(Proxy proxy, boolean enableDebugLog) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(90000, TimeUnit.MILLISECONDS);
        if (proxy != null) {
            builder.proxy(proxy);
        }

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (EhrServerConnect.ENABLE_LOGGING) {
            client = builder.addInterceptor(logging).build();
        } else {
            client = builder.build();
        }
        ENABLE_LOGGING = enableDebugLog;
    }

    /**
     * Makes a GET request.
     *
     * @param requestMetaData     the endpoint to which request has to be sent and the api key of the EHRServer.
     * @return JSONObject which is sent by EHRServer.
     * @throws IOException        is thrown when there is a connection related error.
     * @throws EhrServerException is thrown for all KEHRServer related errors.
     * @throws JSONException      is thrown for parsing errors.
     */
    public JSONObject getRequest(RequestMetaData requestMetaData) throws IOException, EhrServerException, JSONException {
        Request request = createGetRequest(requestMetaData.getUrl(), requestMetaData.getToken());
        return new EhrResponseHandler().handle(client.newCall(request).execute());
    }


    /**
     * Makes a GET request.
     *
     * @param requestMetaData  the endpoint to which request has to be sent and the api key of the EHRServer.
     * @param params is the map of params which has to be sent as query params.
     * @return JSONObject which is sent by EHRServer.
     * @throws IOException        is thrown when there is a connection related error.
     * @throws EhrServerException is thrown for all EHRServer related errors.
     * @throws JSONException      is thrown for parsing errors.
     */
    public JSONObject getRequest(Map<String, Object> params, RequestMetaData requestMetaData) throws IOException, EhrServerException, JSONException {
        Request request = createGetRequest(requestMetaData.getUrl(), params, requestMetaData.getToken());
        return new EhrResponseHandler().handle(client.newCall(request).execute());
    }

    /**
     * Makes a GET request.
     *
     * @param requestMetaData  the endpoint to which request has to be sent and the api key of the EHRServer.
     * @param params is the map of params which has to be sent as query params.
     * @return JSONObject which is sent by EHRServer.
     * @throws IOException        is thrown when there is a connection related error.
     * @throws EhrServerException is thrown for all EHRServer related errors.
     * @throws JSONException      is thrown for parsing errors.
     */
    public String getRequest(Map<String, Object> params, ResponseType format, RequestMetaData requestMetaData) throws IOException, EhrServerException, JSONException {
        if (null == format) {
            format = ResponseType.JSON;
        }
        params.put("format", format.getCode());
        Request request = createGetRequest(requestMetaData.getUrl(), params, requestMetaData.getToken());
        return new EhrResponseHandler().handle(client.newCall(request).execute(), format);
    }


    /**
     * Makes a POST request.
     *
     * @param requestMetaData  the endpoint to which request has to be sent and the api key of the EHRServer.
     * @param params is the map of params which has to be sent in the body.
     * @return JSONObject which is sent by EHRServer.
     * @throws IOException        is thrown when there is a connection related error.
     * @throws EhrServerException is thrown for all EHRServer related errors.
     * @throws JSONException      is thrown for parsing errors.
     */
    public JSONObject postRequest(Map<String, Object> params, RequestMetaData requestMetaData) throws IOException, EhrServerException, JSONException {
        Request request = createPostRequest(requestMetaData.getUrl(), params, requestMetaData.getToken());
        Response response = client.newCall(request).execute();
        return new EhrResponseHandler().handle(response);
    }

    /**
     * POST an Asynchronous Request to ERHRServer.
     * Follows a fire and forget modal.
     * Success and Error handler is expected
     *
     * @param requestMetaData the endpoint to which request has to be sent and the api key of the EHRServer.
     * @param params
     * @throws IOException
     * @throws EhrServerException
     * @throws JSONException
     */
    public void postAsyncRequest(HttpMediaType mediaType, String payload, Map<String, Object> params, RequestMetaData requestMetaData, AsyncResponseHandler responseHandler) throws IOException, EhrServerException, JSONException {
        if (null == responseHandler) {
            throw new IllegalArgumentException("Response handler is expected");
        }
        Request request = createPostRequest(requestMetaData.getUrl(), mediaType, payload, params, requestMetaData.getToken());
        makeAsyncRequest(request, responseHandler);
    }

    /**
     * POST an Asynchronous Request to ERHRServer.
     * Follows a fire and forget modal.
     * Default Success and Error handler will log the response status if Logging is enabled
     * * @param requestMetaData  the endpoint to which request has to be sent and the api key of the EHRServer.
     *
     * @param params
     * @throws IOException
     * @throws EhrServerException
     * @throws JSONException
     */
    public void postAsyncRequest(HttpMediaType mediaType, String payload, Map<String, Object> params, RequestMetaData requestMetaData) throws IOException, EhrServerException, JSONException {

        postAsyncRequest(mediaType, payload, params, requestMetaData, new AsyncResponseHandler() {
            @Override
            public void onError(String code, String message) {
                //Error Handler
                if (ENABLE_LOGGING) {
                    LOGGER.error(String.format("Request failed with - %s - %s", code, message));
                }
            }

            @Override
            public void onSuccess() {
                //Success Handler
                if (ENABLE_LOGGING) {
                    LOGGER.info("Request success");
                }
            }
        });
    }

    private void makeAsyncRequest(Request request, AsyncResponseHandler responseHandler) throws JSONException {

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                responseHandler.onError("SERVER_ERROR", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    new EhrResponseHandler().handle(response);
                    responseHandler.onSuccess();
                } catch (EhrServerException e) {
                    e.printStackTrace();
                    responseHandler.onError("EHR_ERROR", e.message);
                }
            }
        });
    }

    /**
     * Post an XML payload
     *
     * @param requestMetaData  the endpoint to which request has to be sent and the api key of the EHRServer.
     * @param payLoad
     * @param params
     * @return
     * @throws IOException
     * @throws EhrServerException
     * @throws JSONException
     */
    public String postRequestForXml(String payLoad, Map<String, Object> params, RequestMetaData requestMetaData) throws IOException, EhrServerException, JSONException {
        Request request = createXmlPostRequest(requestMetaData.getUrl(), payLoad, params, requestMetaData.getToken());
        Response response = client.newCall(request).execute();
        return new EhrResponseHandler().handle(response, ResponseType.XML);
    }

    /**
     * Creates a GET request.
     *
     * @param url    is the endpoint to which request has to be done.
     * @param apiKey is the api key of the Organization.
     */
    private Request createGetRequest(String url, String apiKey) {
        HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
        return new Request.Builder().url(httpBuilder.build()).header("User-Agent", USER_AGENT).header("Authorization", "Bearer " + apiKey).build();
    }

    /**
     * Creates a GET request.
     *
     * @param url    is the endpoint to which request has to be done.
     * @param apiKey is the api key of the Organization.
     * @param params is the map of data that has to be sent in query params.
     */
    private Request createGetRequest(String url, Map<String, Object> params, String apiKey) {
        HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            httpBuilder.addQueryParameter(entry.getKey(), entry.getValue().toString());
        }
        return new Request.Builder().url(httpBuilder.build()).header("User-Agent", USER_AGENT).header("Authorization", "Bearer " + apiKey).build();
    }


    /**
     * Creates a POST request.
     *
     * @param url    is the endpoint to which request has to be done.
     * @param apiKey is the api key of the Organization.
     * @param params is the map of data that has to be sent in the body.
     */
    private Request createPostRequest(String url, Map<String, Object> params, String apiKey) {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            builder.add(entry.getKey(), entry.getValue().toString());
        }

        RequestBody requestBody = builder.build();
        Request request = new Request.Builder().url(url).post(requestBody).header("User-Agent", USER_AGENT).header("Authorization", "Bearer " + apiKey).build();
        return request;
    }

    private Request createJsonPostRequest(String url, String payload, Map<String, Object> params, String apiKey) {
        return createPostRequest(url, HttpMediaType.JSON, payload, params, apiKey);
    }

    private Request createXmlPostRequest(String url, String payload, Map<String, Object> params, String apiKey) {
        return createPostRequest(url, HttpMediaType.XML, payload, params, apiKey);
    }

    private Request createPostRequest(String url, HttpMediaType mediaType, String payload, Map<String, Object> params, String apiKey) {
        HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            httpBuilder.addQueryParameter(entry.getKey(), entry.getValue().toString());
        }

        RequestBody requestBody = RequestBody.create(parse(mediaType), payload);
        Request request = new Request.Builder().url(httpBuilder.build()).post(requestBody).header("User-Agent", USER_AGENT).header("Authorization", "Bearer " + apiKey).build();
        return request;
    }

    private MediaType parse(HttpMediaType httpMediaType) {
        return MediaType.parse(httpMediaType.getMediaType());
    }

}
