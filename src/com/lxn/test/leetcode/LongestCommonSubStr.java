package com.lxn.test.leetcode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/*
 * 给定两个字符串A和B，长度分别为m和n，要求找出它们最长的公共子串，并返回其长度。例如：
 * */
public class LongestCommonSubStr {
    public static void main(String[] args) {
        String s1 = "acbcbcef";
        String s2 = "bcbce";
        System.out.println(longestCommonSubstr(s1, s2));
    }

    private static String longestCommonSubstr(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) {
            return ""; // 判空处理
        }
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        int maxEnd = 0; // 索引结束位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }

                if (dp[i][j] > maxLength) {
                    maxLength = dp[i][j];
                    maxEnd = i;
                }
            }
        }
        System.out.println("最长公共子串长度： " + maxLength);
        System.out.println(str1.substring(maxEnd - maxLength + 1, maxEnd + 1));
        return "";
    }
}
