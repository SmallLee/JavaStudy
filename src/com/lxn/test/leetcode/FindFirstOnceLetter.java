package com.lxn.test.leetcode;

import javax.print.DocFlavor;
import java.util.HashMap;

public class FindFirstOnceLetter {
    // 查找字符串中第一个只出现一次的字符并且返回它的索引，如果不存在，返回-1,例如输入abcddbea,输出e
    public static void main(String[] args) {
        String s = "abcddbeacef";
        System.out.println(getFirstOneceLetter2(s));
    }

    private static int getFirstOneceLetter(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }
        char[] ch = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>(s.length());
        for (char c : ch) {
            if (map.containsKey(c)) {
                // map中存在，更新次数
                int count = map.get(c);
                map.put(c,++ count);
            } else {
                // map中不存在，次数为1
                map.put(c,1);
            }
        }
        for (char c : ch) {
            if (map.get(c) == 1) {
                return s.indexOf(c);
            }
        }
        return -1;
    }

    private static int getFirstOneceLetter2(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }
        char[] ch = s.toCharArray();
        int[] arr = new int[26];
        int count = 1;
        for(char c : ch) {
            arr[c - 'a'] += count;
        }
        for (int i = 0; i < ch.length; i++) {
            if (arr[ch[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
