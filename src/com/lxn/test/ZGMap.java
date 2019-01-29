package com.lxn.test;

import java.util.Set;

public interface ZGMap<K,V> {
     V put (K k,V v);

     V get(K k);

     int size();

     boolean isEmpty();

     boolean containsKey(K k);

     boolean containsValue(V v);

     boolean equals();

     int hashCode();

     void clear();

     Set<Entry<K,V>> entrySet();

     interface Entry<K,V>{
         K getKey();
         V getValue();
     }
}
