package com.lxn.test.leetcode;

/*
* 给出两个字符串A B，求A与B的最长公共子序列（子序列不要求是连续的）。  比如两个串为： abcicba  abdkscab
ab是两个串的子序列，abc也是，abca也是，其中abca是这两个字符串最长的子序列
* */
public class LongestCommonSubSerial {
    public static void main(String[] args) {
        String s1 = "abcicba";
        String s2 = "abdkscab";
        System.out.println(longestCommonSubSerial(s1, s2));
    }

    private static String longestCommonSubSerial(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) {
            return "";
        }
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int[][] b = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (dp[i][j - 1] >= dp[i - 1][j]) {
                        b[i][j] = 2;
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        b[i][j] = 3;
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        print(b, str1, m, n);
        return "";
    }

    private static void print(int[][] dp, String s, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (dp[i][j] == 1) {
            print(dp, s, i - 1, j - 1);
            System.out.println(s.charAt(i - 1));
        } else if (dp[i][j] == 2) {
            print(dp, s, i, j - 1);
        } else {
            print(dp, s, i - 1, j);
        }
    }
}
