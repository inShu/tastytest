package com.tastytest.tests;

import com.tastytest.core.RestService;
import org.testng.annotations.Test;

public class Tests {

    @Test
    public void SimpleTest()
    {
        RestService service = new RestService("http://talennsy.org");

        service.addEndpoint("endpoint1");
        service.addEndpoint("endpoint2");
    }
}
