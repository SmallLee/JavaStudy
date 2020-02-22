package com.lxn.test.leetcode;

import javax.sql.rowset.CachedRowSet;
import java.util.*;

/*
 * 给定一个字符串，找出不含有重复字符的最长子串长度，例如  abcbdda ,输出3
 * */
public class LongestNoSameLetterStr {
    public static void main(String[] args) {
        String s = "abcbdda";
        longestNoSameLetter(s);
    }
    /*
     * 哈希法 map
     * */
    private static void longestNoSameLetter(String s) {
        if (s == null || s.isEmpty()) {
            return;
        }
        int left = 0, res = 0;
        // 记录字符上次出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 取max是为了保证窗口左边界一直增大
                left = Math.max(map.get(s.charAt(i)), left);
            }
            // 当前滑动窗口的值和之前记录的最大值比较
            res = Math.max(res, i - left + 1);
            map.put(s.charAt(i), i + 1);
        }
        System.out.println(res);
    }

    // 3.数组
    // abcbdda
    /* 对于每一个遍历到的字符串，如果不存在，则长度为i-left + 1
        如果存在，
    * */
    private static void longestNoSameLetter2(String s) {
        if (s == null || s.isEmpty()) {
            return;
        }
        int[] m = new int[256];
        int left = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            left = Math.max(left, m[s.charAt(i)]);
            res = Math.max(res, i - left + 1);
            m[s.charAt(i)] = i + 1;
        }
        System.out.println(res);
    }
}
