package com.test.component;

import com.google.gson.Gson;
import com.mashape.unirest.http.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnirestObjectMapper implements ObjectMapper {

    private final Gson gson;

    @Autowired
    public UnirestObjectMapper(Gson gson) {
        this.gson = gson;
    }

    @Override
    public <T> T readValue(String value, Class<T> valueType) {
        try {
            T response = gson.fromJson(value, valueType);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String writeValue(Object value) {
        try {
            String strValue = gson.toJson(value);
            return strValue;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
