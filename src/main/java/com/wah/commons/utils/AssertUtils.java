package com.wah.commons.utils;

import java.util.Collection;
import java.util.Map;

public class AssertUtils{

    public static void notNull(Object object, String message){
        if(object == null){
            throw new IllegalArgumentException(message);
        }
    }

    public static void hasText(String str, String message){
        if(StringUtils.isBlank(str)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void hasLength(String str, String message){
        if(StringUtils.length(str) == 0){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(Collection collection, String message){
        if(CollectionUtils.isEmpty(collection)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(Map map, String message){
        if(CollectionUtils.isEmpty(map)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(byte[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(char[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(boolean[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(short[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(int[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(long[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(float[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(double[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(String[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> void notEmpty(T[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void between(byte compare, byte min, byte max, String message){
        if(NumberUtils.between(compare, min, max)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void between(char compare, char min, char max, String message){
        if(NumberUtils.between(compare, min, max)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void between(short compare, short min, short max, String message){
        if(NumberUtils.between(compare, min, max)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void between(int compare, int min, int max, String message){
        if(NumberUtils.between(compare, min, max)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void between(long compare, long min, long max, String message){
        if(NumberUtils.between(compare, min, max)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void between(float compare, float min, float max, String message){
        if(NumberUtils.between(compare, min, max)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void between(double compare, double min, double max, String message){
        if(NumberUtils.between(compare, min, max)){
            throw new IllegalArgumentException(message);
        }
    }
}
