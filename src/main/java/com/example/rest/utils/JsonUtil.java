package com.example.rest.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;

public class JsonUtil {
    private static final Gson gson = new Gson();

    public static String toJson(Object o) {
        return gson.toJson(o);
    }
    
    public static <T> T fromJson(BufferedReader reader, Class<T> clazz) throws JsonSyntaxException {
        return gson.fromJson(reader, clazz);
    }
}
