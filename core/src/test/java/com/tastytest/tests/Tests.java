package com.tastytest.tests;

import org.testng.annotations.Test;

public class Tests {
    private TalennsyService service = new TalennsyService();

    @Test
    public void SimpleTest()
    {
        DataClass resp = service.getData();

        System.out.println("Response: \"" + resp.getData() + "\"");
    }
}
