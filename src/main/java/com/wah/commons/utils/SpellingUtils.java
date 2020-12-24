package com.wah.commons.utils;

import com.google.common.base.CaseFormat;

public class SpellingUtils{

    public static String underline(String str){
        AssertUtils.notNull(str, "格式化的字符串不能为空");

        return StringUtils.isBlank(str) ? "" : CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
    }

    public static String camel(String str){
        AssertUtils.notNull(str, "格式化的字符串不能为空");

        return StringUtils.isBlank(str) ? "" : CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
    }
}
