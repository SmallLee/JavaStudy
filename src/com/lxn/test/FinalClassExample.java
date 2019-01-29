package com.lxn.test;

import java.util.*;

/**
 * 不可变类写法
 */
// 将类声明为final
public final class FinalClassExample {
    // 所有成员声明为final,
    private final int age;
    private final HashMap hashMap;

    // 在构造方法中对成员进行初始化
    public FinalClassExample(int age,HashMap hashMap) {
        this.age = age;
        Set key = hashMap.keySet();
        HashMap tempMap = new HashMap();
        // 对象需要深拷贝
        while (key.iterator().hasNext()) {
            tempMap.put(key,hashMap.get(key));
        }
        this.hashMap = tempMap;
    }
    // 在get方法中，返回对象的拷贝
    public HashMap getHashMap() {
         int a = 0;
        List list = new ArrayList();
        new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                o1 = 2;
                System.out.println(a);
                return 0;
            }
        };
        return (HashMap) hashMap.clone();
    }
}
