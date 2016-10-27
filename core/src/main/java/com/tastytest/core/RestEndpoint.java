package com.tastytest.core;

public class RestEndpoint {
    private String path;

    public RestEndpoint(String path)
    {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
