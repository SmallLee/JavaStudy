package com.lxn.test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.print.DocFlavor;
import java.util.*;

// 测试并发修改异常
public class TestArrayList {
    static List<String> strList = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        strList.add("A");
        set.contains("df");
        strList.add("B");
        strList.add("C");
        strList.add("D");
        Iterator<String> iterator = strList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("B")) {
                iterator.remove();
            }
        }
        System.out.println(Arrays.toString(strList.toArray()));
    }
}

