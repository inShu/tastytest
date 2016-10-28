package com.tastytest.tests;

import com.tastytest.core.DataType;
import com.tastytest.utils.CommonUtils;
import org.testng.annotations.Test;

public class Tests {
    private TalennsyService service = new TalennsyService();

    @Test
    public void SimpleTest()
    {
        DataClass resp = service.getData();

        System.out.println("Response: \"" + resp.getData() + "\"");
        System.out.println(CommonUtils.convertObjectToString(resp, DataType.JSON));
    }
}
