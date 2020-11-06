package com.sayone.online.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class ResponseUtils {

    public static Map<String,Object> convertObjectToMap(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.convertValue(obj,Map.class);
    }
}
