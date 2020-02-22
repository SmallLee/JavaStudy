package com.lxn.test.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCacheMap<K,V> extends LinkedHashMap<K,V> {
    private int mCacheSize;
    LruCacheMap(int cacheSize){
        super(3,4.5f,true);
        this.mCacheSize = cacheSize;
    }

    // 重写此方法决定何时移除最老的数据
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > mCacheSize;
    }
}
