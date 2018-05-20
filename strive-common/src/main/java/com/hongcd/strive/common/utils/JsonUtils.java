package com.hongcd.strive.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public abstract class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String obj2Json(Object value) throws JsonProcessingException {
        return objectMapper.writeValueAsString(value);
    }

    public static <T> T json2Obj(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }
}