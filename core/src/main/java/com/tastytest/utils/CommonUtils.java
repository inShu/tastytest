package com.tastytest.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tastytest.core.DataType;

import java.io.IOException;

public class CommonUtils
{
    private static ObjectMapper mapper;

    //TODO: Singleton or this shit?
    static {
        mapper = new ObjectMapper();
    }

    private static <T> T convertXmlToObject(String source, Class toClass)
    {
        return null;
    }

    private static <T> T convertJsonToObject(String source, Class toClass)
    {
        T value;

        try
        {
            value = (T) mapper.readValue(source, toClass);
        } catch(IOException exc) { throw new RuntimeException(exc.getMessage()); }

        return value;
    }

    public static <T> T convertStringToObject(String source, Class toClass, DataType type)
    {
        switch(type)
        {
            default:
            case JSON:
                return convertJsonToObject(source, toClass);
            case SOAP:
            case XML:
                return convertXmlToObject(source, toClass);
        }
    }

    public static <T> String convertObjectToString(T object, DataType type)
    {
        switch(type)
        {
            default:
            case JSON:
                try
                {
                    return mapper.writeValueAsString(object);
                } catch(JsonProcessingException exc) { throw new RuntimeException(exc.getMessage()); }
        }
    }
}
