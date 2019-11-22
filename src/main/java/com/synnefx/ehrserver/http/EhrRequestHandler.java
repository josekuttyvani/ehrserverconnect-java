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

    private OkHttpClient client;
    private String USER_AGENT = "ehrserverconnect/1.0.0";


    /**
     * Initialize request handler.
     *
     * @param proxy to be set for making requests.
     */
    public EhrRequestHandler(Proxy proxy) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10000, TimeUnit.MILLISECONDS);
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
    }

    /**
     * Makes a GET request.
     *
     * @param url    is the endpoint to which request has to be sent.
     * @param apiKey is the api key of the EHRServer.
     * @return JSONObject which is sent by EHRServer.
     * @throws IOException        is thrown when there is a connection related error.
     * @throws EhrServerException is thrown for all KEHRServer related errors.
     * @throws JSONException      is thrown for parsing errors.
     */
    public JSONObject getRequest(String url, String apiKey) throws IOException, EhrServerException, JSONException {
        Request request = createGetRequest(url, apiKey);
        return new EhrResponseHandler().handle(client.newCall(request).execute());
    }


    /**
     * Makes a GET request.
     *
     * @param url    is the endpoint to which request has to be sent.
     * @param apiKey is the api key of the EHRServer.
     * @param params is the map of params which has to be sent as query params.
     * @return JSONObject which is sent by EHRServer.
     * @throws IOException        is thrown when there is a connection related error.
     * @throws EhrServerException is thrown for all EHRServer related errors.
     * @throws JSONException      is thrown for parsing errors.
     */
    public JSONObject getRequest(String url, Map<String, Object> params, String apiKey) throws IOException, EhrServerException, JSONException {
        Request request = createGetRequest(url, params, apiKey);
        return new EhrResponseHandler().handle(client.newCall(request).execute());
    }

    /**
     * Makes a GET request.
     *
     * @param url    is the endpoint to which request has to be sent.
     * @param apiKey is the api key of the EHRServer.
     * @param params is the map of params which has to be sent as query params.
     * @return JSONObject which is sent by EHRServer.
     * @throws IOException        is thrown when there is a connection related error.
     * @throws EhrServerException is thrown for all EHRServer related errors.
     * @throws JSONException      is thrown for parsing errors.
     */
    public String getRequest(String url, Map<String, Object> params, ResponseType format, String apiKey) throws IOException, EhrServerException, JSONException {
        if (null == format) {
            format = ResponseType.JSON;
        }
        params.put("format", format.getCode());
        Request request = createGetRequest(url, params, apiKey);
        return new EhrResponseHandler().handle(client.newCall(request).execute(), format);
    }


    /**
     * Makes a POST request.
     *
     * @param url    is the endpoint to which request has to be sent.
     * @param apiKey is the api key of the EHRServer.
     * @param params is the map of params which has to be sent in the body.
     * @return JSONObject which is sent by EHRServer.
     * @throws IOException        is thrown when there is a connection related error.
     * @throws EhrServerException is thrown for all EHRServer related errors.
     * @throws JSONException      is thrown for parsing errors.
     */
    public JSONObject postRequest(String url, Map<String, Object> params, String apiKey) throws IOException, EhrServerException, JSONException {
        Request request = createPostRequest(url, params, apiKey);
        Response response = client.newCall(request).execute();
        return new EhrResponseHandler().handle(response);
    }

    public void postAsyncRequest(String url, Map<String, Object> params, String apiKey) throws IOException, EhrServerException, JSONException {
        Request request = createPostRequest(url, params, apiKey);
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    new EhrResponseHandler().handle(response);
                } catch (EhrServerException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Post an XML payload
     *
     * @param url
     * @param payLoad
     * @param params
     * @param apiKey
     * @return
     * @throws IOException
     * @throws EhrServerException
     * @throws JSONException
     */
    public String postRequestForXml(String url, String payLoad, Map<String, Object> params, String apiKey) throws IOException, EhrServerException, JSONException {
        Request request = createXmlPostRequest(url, payLoad, params, apiKey);
        Response response = client.newCall(request).execute();
        return new EhrResponseHandler().handle(response, ResponseType.XML);
    }

    /**
     * Creates a GET request.
     *
     * @param url    is the endpoint to which request has to be done.
     * @param apiKey is the api key of the Organization.
     */
    public Request createGetRequest(String url, String apiKey) {
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
    public Request createGetRequest(String url, Map<String, Object> params, String apiKey) {
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
    public Request createPostRequest(String url, Map<String, Object> params, String apiKey) {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            builder.add(entry.getKey(), entry.getValue().toString());
        }

        RequestBody requestBody = builder.build();
        Request request = new Request.Builder().url(url).post(requestBody).header("User-Agent", USER_AGENT).header("Authorization", "Bearer " + apiKey).build();
        return request;
    }

    public Request createJsonPostRequest(String url, String payload, Map<String, Object> params, String apiKey) {
        return createPostRequest(url, MediaType.parse("application/json; charset=utf-8"), payload, params, apiKey);
    }

    public Request createXmlPostRequest(String url, String payload, Map<String, Object> params, String apiKey) {
        return createPostRequest(url, MediaType.parse("application/xml; charset=utf-8"), payload, params, apiKey);
    }

    public Request createPostRequest(String url, MediaType mediaType, String payload, Map<String, Object> params, String apiKey) {
        HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            httpBuilder.addQueryParameter(entry.getKey(), entry.getValue().toString());
        }
        RequestBody requestBody = RequestBody.create(mediaType, payload);
        Request request = new Request.Builder().url(httpBuilder.build()).post(requestBody).header("User-Agent", USER_AGENT).header("Authorization", "Bearer " + apiKey).build();
        return request;
    }

}
