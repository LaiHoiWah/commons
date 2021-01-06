package com.wah.commons.utils;

import java.math.BigInteger;

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

    public static String binary(long dec){
        return toRadix(Long.toString(dec), 2);
    }

    public static String octal(long dec){
        return toRadix(Long.toString(dec), 8);
    }

    public static String decimal(long dec){
        return toRadix(Long.toString(dec), 10);
    }

    public static String hex(long dec){
        return toRadix(Long.toString(dec), 16);
    }

    public static String to32(long dec){
        return toRadix(Long.toString(dec), 32);
    }

    public static String to36(long dec){
        return toRadix(Long.toString(dec), 36);
    }

    public static String toRadix(String dec, int radixTo){
        return convert(dec, 10, radixTo);
    }

    public static String convert(String number, int radix, int radixTo){
        AssertUtils.hasText(number, "转换的数字不能为空");

        if(radix >= Character.MIN_RADIX && radix <= Character.MAX_RADIX){
            return new BigInteger(number, radix).toString(radixTo);
        }

        //TODO 更高进制转换
        return number;
    }
}
