package com.tastytest.core;

public class RestService {
    private String url;
    private String userName;
    private String password;

    public RestService(String url, String userName, String password)
    {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }
}
