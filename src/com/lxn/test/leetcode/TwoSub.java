package com.lxn.test.leetcode;

import com.sun.xml.internal.ws.message.ByteArrayAttachment;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/*
* 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
* [1,2,3,4,5]  target = 5
* return [0,3]
* */
public class TwoSub {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
//        System.out.println(Arrays.toString(getIndex(arr, 5)));
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        ListIterator<String> listIterator = arrayList.listIterator();
        arrayList.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("3");
            }
        });
    /*    System.out.println(Arrays.toString(arrayList.toArray()));
        arrayList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });*/
       /* arrayList.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return s + "-a";
            }
        });
        System.out.println(Arrays.toString(arrayList.toArray()));*/
       LinkedList<String> linkedList = new LinkedList<>();
       linkedList.add("A");
       linkedList.add("B");
       linkedList.add("C");
       linkedList.removeFirst();
    }
    private static int[] getIndex(int[] arr,int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
            int com = target - arr[i]; // 需要查找的索引对应的值
            if (map.containsKey(com)) {
                return new int[]{map.get(com),i};
            }
        }
        return null;
    }
}
