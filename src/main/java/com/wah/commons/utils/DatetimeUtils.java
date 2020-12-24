package com.wah.commons.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeUtils{

    private static final String FULL_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss.SS";

    public static String toString(Date date){
        return toString(date, FULL_TIME_PATTERN);
    }

    public static String toString(Long timestamp){
        return toString(timestamp, FULL_TIME_PATTERN);
    }

    public static String toString(Date date, String pattern){
        AssertUtils.notNull(date, "转换的日期对象不能为空");

        if(StringUtils.isBlank(pattern)){
            pattern = FULL_TIME_PATTERN;
        }

        return new SimpleDateFormat(pattern).format(date);
    }

    public static String toString(Long timestamp, String pattern){
        AssertUtils.notNull(timestamp, "转换的时间戳不能为空");

        return toString(new Date(timestamp), pattern);
    }

    public static Date parse(String date, String... patterns) throws ParseException{
        AssertUtils.hasText(date, "解析的日期信息不能为空");
        AssertUtils.notEmpty(patterns, "解析的日期模板不能为空");

        return DateUtils.parseDate(date, patterns);
    }
}
