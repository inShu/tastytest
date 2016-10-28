package com.tastytest.core;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.config.DecoderConfig;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.http.Method;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.tastytest.utils.CommonUtils;

import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.config.RestAssuredConfig.newConfig;

// TODO: cookie authentication
// TODO: oath2 authentication
// TODO: authentication specification
// TODO: normal authorization
// TODO: add all call methods
// TODO: RequestSpecBuilder meaning
// TODO: Checking statusCode() after then()
// TODO: .get('/lotto/{id}', 5) - will work?
public abstract class RestService {
    private String url;
    private String userName;
    private String password;
    private String charset;
    private DataType dataType;

    private RestAssuredConfig config;
    private RequestSpecBuilder specBuilder;
    private HashMap<String, RestEndpoint> endpoints;

    protected RestService(String url)
    {
        this(url, null, null, "UTF-8", DataType.JSON);
    }

    protected RestService(String url, String userName, String password, String charset, DataType dataType)
    {
        this.url = url;
        this.userName = userName;
        this.password = password;
        this.charset = charset;
        this.dataType = dataType;

        this.endpoints = new HashMap<String, RestEndpoint>();

        serviceInit();
    }

    private void serviceInit()
    {
        this.config = specifyRestConfig();
        this.specBuilder = specifyRequestSpecBuilder();
    }

    protected RestEndpoint addEndpoint(String path, String name)
    {
        if (this.endpoints.containsKey(name))
            throw new RuntimeException("Service '" + this.url + "' already has endpoint '" + name + "'");

        RestEndpoint endpoint = new RestEndpoint(path);

        this.endpoints.put(name, endpoint);

        return endpoint;
    }

    protected final RestAssuredConfig getDefaultConfig()
    {
        return newConfig().decoderConfig(DecoderConfig.decoderConfig().defaultContentCharset(this.charset));
    }

    /**
     * Override this function to specify config parameters.
     * Use getDefaultConfig() to obtain default class
     * which should be configured.
     * @return
     */
    protected RestAssuredConfig specifyRestConfig()
    {
        return getDefaultConfig();
    }

    protected final RequestSpecBuilder getDefaultRequestSpecBuilder()
    {
        return new RequestSpecBuilder();
    }

    /**
     * Override this function to specify request builder parameters.
     * Use getDefaultRequestSpecBuilder() to obtain default class
     * which should be configured.
     * @return
     */
    protected RequestSpecBuilder specifyRequestSpecBuilder()
    {
        return getDefaultRequestSpecBuilder();
    }

    private ContentType dataTypeToContentType(DataType dataType)
    {
        switch(dataType)
        {
            case JSON:
                return ContentType.JSON;
            case SOAP:
            case XML:
                return ContentType.XML;
            default:
                return ContentType.TEXT;
        }
    }

    private RequestSpecification request()
    {
        return given().baseUri(this.url).config(this.config).contentType(dataTypeToContentType(this.dataType));
    }

    protected RestEndpoint getEndpoint(String name)
    {
        if (this.endpoints.containsKey(name))
            return this.endpoints.get(name);

        throw new RuntimeException("Service '" + this.url + "' have no endpoint '" + name + "'");
    }

    private Response makeRequest(String endpointName, HashMap<String, String> params, Method methodType)
    {
        RestEndpoint end = getEndpoint(endpointName);
        String callUrl = this.url + "/" + end.getPath();
        RequestSpecification spec = (params == null ? request().when():request().given().queryParams(params).when());
        Response response;

        switch(methodType)
        {
            default:
            case GET:
                response = spec.get(callUrl);
                break;
            case PUT:
                response = spec.put(callUrl);
                break;
            case POST:
                response = spec.post(callUrl);
                break;
        }

        return response.thenReturn();
    }

    protected Response makeGetRequest(String endpointName, HashMap<String, String> params)
    {
        return makeRequest(endpointName, params, Method.GET);
    }

    protected Response makePostRequest(String endpointName, HashMap<String, String> params)
    {
        return makeRequest(endpointName, params, Method.POST);
    }

    protected Response makePutRequest(String endpointName, HashMap<String, String> params)
    {
        return makeRequest(endpointName, params, Method.PUT);
    }

    //TODO: add custom path
    protected <T> T getObjectFromResponse(Response response, Class toClass)
    {
        if (response == null)
            throw new RuntimeException("Can't convert nulled response to object");

        return CommonUtils.convertStringToObject(response.body().asString(), toClass, this.dataType);
    }
}
