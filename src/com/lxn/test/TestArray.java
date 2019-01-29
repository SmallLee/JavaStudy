package com.lxn.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestArray {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2");
        System.out.println(list.getClass()); // class java.util.Arrays$ArrayList
        Object[] objects = list.toArray();
        System.out.println(objects.getClass()); // class [Ljava.lang.String;
        ArrayList arrayList = new ArrayList();
    }
}
