package com.lxn.test.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/*
* 两个字符串中的交集
* */
public class SameLetterInTwoStr {
    public static void main(String[] args) {
        String str1 = "abcddopk";
        String str2 = "adope";
        result(str1,str2);
    }

    private static void result(String str1,String str2) {
        HashSet<Character> set = new HashSet<>();
        char[] ch = str1.toCharArray();
        for (char c : ch) {
            set.add(c);
        }
        char[] ch2 = str2.toCharArray();
        for (char c :ch2) {
            if (set.contains(c)) {
                System.out.println(c);
            }
        }
    }
}
