package com.tastytest.tests;

import com.tastytest.core.RestService;

import java.util.HashMap;

public class TalennsyService extends RestService
{
    public TalennsyService()
    {
        super("http://alanir.talennsy.org");

        addEndpoint("first.php", "first");
    }

    public DataClass getData()
    {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("param", "ku-ku");

        return getObjectFromResponse(makePostRequest("first", "qwe", map, null), DataClass.class);
    }
}
