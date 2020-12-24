package com.wah.commons.utils;

import com.google.gson.*;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;

public class GsonUtils{

    private static final Gson GSON = getGson();

    public static String serialize(Object object){
        return serialize(object, GSON);
    }

    public static String serialize(Object object, Gson gson){
        if(gson == null){
            gson = GSON;
        }

        return gson.toJson(object);
    }

    public static <T> T deserialize(String json, Class<T> clazz){
        return deserialize(json, clazz, GSON);
    }

    public static <T> T deserialize(String json, Type type){
        return deserialize(json, type, GSON);
    }

    public static <T> T deserialize(String json, Class<T> clazz, Gson gson){
        if(gson == null){
            gson = GSON;
        }

        return gson.fromJson(json, clazz);
    }

    public static <T> T deserialize(String json, Type type, Gson gson){
        if(gson == null){
            gson = GSON;
        }

        return gson.fromJson(json, type);
    }

    public static Gson getGson(){
        return getGson(false, false, true, null);
    }

    public static Gson getGson(boolean serializeNulls, boolean escapeHtmlChars, boolean timestamp, String datePattern){
        return getBuilder(serializeNulls, escapeHtmlChars, timestamp, datePattern).create();
    }

    private static GsonBuilder getBuilder(boolean serializeNulls, boolean escapeHtmlChars, boolean timestamp, String datePattern){
        GsonBuilder builder = new GsonBuilder();

        if(serializeNulls){
            builder.serializeNulls();
        }

        if(!escapeHtmlChars){
            builder.disableHtmlEscaping();
        }

        if(timestamp){
            builder.registerTypeAdapter(Date.class, new DateDeserializer())
                   .registerTypeAdapter(Date.class, new DateSerializer())
                   .setDateFormat(DateFormat.LONG);
        }

        if(!timestamp && StringUtils.isNotBlank(datePattern)){
            builder.setDateFormat(datePattern);
        }

        return builder;
    }

    private static class DateDeserializer implements JsonDeserializer<Date>{

        @Override
        public Date deserialize(JsonElement element, Type typeOf, JsonDeserializationContext context) throws JsonParseException{
            return new Date(element.getAsJsonPrimitive().getAsLong());
        }
    }

    private static class DateSerializer implements JsonSerializer<Date>{

        @Override
        public JsonElement serialize(Date date, Type typeOf, JsonSerializationContext context){
            return new JsonPrimitive(date.getTime());
        }
    }
}
