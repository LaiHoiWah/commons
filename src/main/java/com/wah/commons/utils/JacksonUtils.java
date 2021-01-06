package com.wah.commons.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wah.commons.security.exception.DeserializeException;
import com.wah.commons.security.exception.SerializeException;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;

public class JacksonUtils{

    private static final ObjectMapper MAPPER = getMapper();

    public static String serialize(Object object) throws SerializeException {
        return serialize(object, MAPPER);
    }

    public static String serialize(Object object, ObjectMapper mapper) throws SerializeException{
        if(mapper == null){
            mapper = MAPPER;
        }

        try{
            return mapper.writeValueAsString(object);
        }catch(Exception e){
            throw new SerializeException(e.getMessage(), e);
        }
    }

    public static <T> T deserialize(String json, Class<T> clazz) throws DeserializeException {
        return deserialize(json, clazz, MAPPER);
    }

    public static <T> T deserialize(String json, TypeReference<T> type) throws DeserializeException{
        return deserialize(json, type, MAPPER);
    }

    public static <T> T deserialize(String json, Class<T> clazz, ObjectMapper mapper) throws DeserializeException{
        try{
            return mapper.readValue(json, clazz);
        }catch(Exception e){
            throw new DeserializeException(e.getMessage(), e);
        }
    }

    public static <T> T deserialize(String json, TypeReference<T> type, ObjectMapper mapper) throws DeserializeException{
        try{
            return mapper.readValue(json, type);
        }catch(Exception e){
            throw new DeserializeException(e.getMessage(), e);
        }
    }

    public static ObjectMapper getMapper(){
        return getMapper(true, true, true, true, null);
    }

    public static ObjectMapper getMapper(boolean serializeNulls, boolean lowerCamelCase, boolean unknownProperties,
                                         boolean timestamps, String datePattern){
        ObjectMapper mapper = new ObjectMapper();

        if(serializeNulls){
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }

        if(lowerCamelCase){
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
        }

        if(unknownProperties){
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        }

        if(timestamps){
            mapper.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        }

        if(!timestamps && StringUtils.isNotBlank(datePattern)){
            mapper.setDateFormat(new SimpleDateFormat(datePattern));
        }

        return mapper;
    }
}
