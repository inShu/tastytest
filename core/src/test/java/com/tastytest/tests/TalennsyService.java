package com.tastytest.tests;

import com.tastytest.core.RestService;

public class TalennsyService extends RestService
{
    public TalennsyService()
    {
        super("http://alanir.talennsy.org");

        addEndpoint("first.php", "first");
    }

    public DataClass getData()
    {
        return getObjectFromResponse(makeGetRequest("first", null), DataClass.class);
    }
}
