package com.wah.commons.utils;

public class StringUtils{

    public static boolean isNotBlank(CharSequence cs){
        return !isBlank(cs);
    }

    public static boolean isBlank(CharSequence cs){
        return org.apache.commons.lang3.StringUtils.isBlank(cs);
    }

    public static int length(CharSequence cs){
        return org.apache.commons.lang3.StringUtils.length(cs);
    }
}
