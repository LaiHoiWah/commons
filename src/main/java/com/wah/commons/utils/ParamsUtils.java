package com.wah.commons.utils;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParamsUtils{

    private static final String AND_CHARACTER   = "&";
    private static final String EQUAL_CHARACTER = "=";
    private static final String KEY             = "key";
    private static final String VALUE           = "value";
    private static final String PAIR_REGEX      = "(?<key>\\S+)=(?<value>\\S+)";

    public static Map<String, String> asMap(String params){
        if(StringUtils.isBlank(params)){
            return Maps.newHashMapWithExpectedSize(0);
        }

        if(params.startsWith("?")){
            params = params.replace("?", "");
        }

        //分割
        String[] pairs = params.split(AND_CHARACTER);
        //解析
        if(ArrayUtils.isNotEmpty(pairs)){
            //输出
            Map<String, String> result = Maps.newHashMap();

            Arrays.stream(pairs)
                  .forEach(pair -> {
                      Map<String, String> param = parse(pair);

                      if(CollectionUtils.isNotEmpty(param)){
                          result.put(param.get(KEY), param.get(VALUE));
                      }
                  });

            return result;
        }

        return Maps.newHashMapWithExpectedSize(0);
    }

    public static String toString(Map<String, Object> params){
        if(CollectionUtils.isEmpty(params)){
            return StringUtils.EMPTY;
        }

        //输出
        StringBuilder sb = new StringBuilder();

        params.forEach((key, value) -> {
            if(StringUtils.isNotBlank(key)){
                sb.append(key)
                  .append(EQUAL_CHARACTER)
                  .append(value)
                  .append(AND_CHARACTER);
            }
        });

        return StringUtils.deleteLastChar(sb.toString(), AND_CHARACTER);
    }

    private static Map<String, String> parse(String param){
        if(StringUtils.isBlank(param)){
            return Maps.newHashMapWithExpectedSize(0);
        }

        Pattern pattern = Pattern.compile(PAIR_REGEX);
        Matcher matcher = pattern.matcher(param);

        if(matcher.matches()){
            //输出
            Map<String, String> result = Maps.newHashMapWithExpectedSize(2);

            result.put(KEY, matcher.group(KEY));
            result.put(VALUE, matcher.group(VALUE));

            return result;
        }

        return Maps.newHashMapWithExpectedSize(0);
    }
}
