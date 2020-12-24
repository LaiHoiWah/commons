package com.wah.commons.utils;

import java.util.Collection;
import java.util.Map;

public class CollectionUtils{

    public static boolean isNotEmpty(Collection collection){
        return !isEmpty(collection);
    }

    public static boolean isNotEmpty(Map map){
        return !isEmpty(map);
    }

    public static boolean isEmpty(Collection collection){
        return (collection == null || collection.isEmpty());
    }

    public static boolean isEmpty(Map map){
        return (map == null || map.isEmpty());
    }
}
