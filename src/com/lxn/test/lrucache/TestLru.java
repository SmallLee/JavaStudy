package com.lxn.test.lrucache;

import java.util.Iterator;
import java.util.Map;

public class TestLru {
    public static void main(String[] args) {
        LruCacheMap<String,String> cacheMap = new LruCacheMap<>(3);
        cacheMap.put("1","One");
        cacheMap.put("2","two");
        cacheMap.put("3","three");
        cacheMap.put("4","four");
        cacheMap.put("2","two");
        cacheMap.put("3","three");
        for (Map.Entry<String, String> next : cacheMap.entrySet()) {
            System.out.println(next.getKey()); // 4,2,3
        }
    }
}
