package com.wah.commons.utils;

public class NumberUtils{

    public static boolean between(byte compare, byte min, byte max){
        return compare >= min && compare <= max;
    }

    public static boolean between(char compare, char min, char max){
        return compare >= min && compare <= max;
    }

    public static boolean between(short compare, short min, short max){
        return compare >= min && compare <= max;
    }

    public static boolean between(int compare, int min, int max){
        return compare >= min && compare <= max;
    }

    public static boolean between(long compare, long min, long max){
        return compare >= min && compare <= max;
    }

    public static boolean between(float compare, float min, float max){
        return compare >= min && compare <= max;
    }

    public static boolean between(double compare, double min, double max){
        return compare >= min && compare <= max;
    }
}
