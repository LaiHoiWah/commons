package com.wah.commons.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils{

    private static final String FULL_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss.S";

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

    public static Date addYears(Date date, int amount){
        return add(date, Calendar.YEAR, amount);
    }

    public static Date addMonths(Date date, int amount){
        return add(date, Calendar.MONTH, amount);
    }

    public static Date addWeeks(Date date, int amount){
        return add(date, Calendar.WEEK_OF_YEAR, amount);
    }

    public static Date addDays(Date date, int amount){
        return add(date, Calendar.DATE, amount);
    }

    public static Date addHours(Date date, int amount){
        return add(date, Calendar.HOUR, amount);
    }

    public static Date addMinutes(Date date, int amount){
        return add(date, Calendar.MINUTE, amount);
    }

    public static Date addSeconds(Date date, int amount){
        return add(date, Calendar.SECOND, amount);
    }

    public static Date addMilliseconds(Date date, int amount){
        return add(date, Calendar.MILLISECOND, amount);
    }

    public static Date add(Date date, int field, int amount){
        AssertUtils.notNull(date, "计算的日期不能为空");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);

        return calendar.getTime();
    }

    public static Date setYears(Date date, int amount){
        return set(date, Calendar.YEAR, amount);
    }

    public static Date setMonths(Date date, int amount){
        return set(date, Calendar.MONTH, amount);
    }

    public static Date setWeeks(Date date, int amount){
        return set(date, Calendar.WEEK_OF_YEAR, amount);
    }

    public static Date setDays(Date date, int amount){
        return set(date, Calendar.DATE, amount);
    }

    public static Date setHours(Date date, int amount){
        return set(date, Calendar.HOUR, amount);
    }

    public static Date setMinutes(Date date, int amount){
        return set(date, Calendar.MINUTE, amount);
    }

    public static Date setSeconds(Date date, int amount){
        return set(date, Calendar.SECOND, amount);
    }

    public static Date setMilliseconds(Date date, int amount){
        return set(date, Calendar.MILLISECOND, amount);
    }

    private static Date set(Date date, int field, int amount){
        AssertUtils.notNull(date, "计算的日期不能为空");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(field, amount);

        return calendar.getTime();
    }
}
