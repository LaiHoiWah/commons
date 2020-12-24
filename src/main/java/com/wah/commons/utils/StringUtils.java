package com.wah.commons.utils;

public class StringUtils{

    public static final String EMPTY = "";

    public static boolean isNotBlank(CharSequence cs){
        return !isBlank(cs);
    }

    public static boolean isBlank(CharSequence cs){
        return org.apache.commons.lang3.StringUtils.isBlank(cs);
    }

    public static int length(CharSequence cs){
        return org.apache.commons.lang3.StringUtils.length(cs);
    }

    public static String deleteLastCharOf(String str, String ch){
        if(isBlank(str)){
            return str;
        }

        if(isBlank(ch)){
            return str;
        }

        int index = str.lastIndexOf(ch);

        return str.substring(0, index) + (index == str.length() - 1 ? "" : str.substring(index + 1));
    }
}
