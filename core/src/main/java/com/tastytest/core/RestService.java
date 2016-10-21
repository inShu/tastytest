package com.tastytest.core;

import java.util.HashMap;
import java.util.HashSet;

public class RestService {
    private String url;
    private String userName;
    private String password;
    private HashMap<String, RestEndpoint> endpoints;

    public RestService(String url)
    {
        this(url, null, null);
    }

    public RestService(String url, String userName, String password)
    {
        this.url = url;
        this.userName = userName;
        this.password = password;

        this.endpoints = new HashMap<String, RestEndpoint>();
    }

    public RestEndpoint addEndpoint(String path)
    {
        RestEndpoint endpoint = new RestEndpoint(path);

        this.endpoints.put(path, endpoint);

        return endpoint;
    }
}
