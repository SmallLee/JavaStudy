package com.lxn.test.leetcode;

import java.util.Arrays;

/*
*  数塔问题，给定一个数塔，请出从顶部到底部的最大路径和
*  例如
*                 9
              12     15
          10       6      8
       2       18       9      5
  19      7       10       4     16

  得到 9 + 12 + 10 + 18 + 10 = 59
* */
public class NumberTower {
    public static void main(String[] args) {
        int data[][] = {
                {9},
                {12, 15},
                {10, 6, 8},
                {2, 18, 9, 5},
                {19, 7, 10, 4, 16}
        };
        int[][] dp = numberTower(data);
        for (int[] d : dp) {
            System.out.println(Arrays.toString(d));
        }
        System.out.println("最大路径和 " + dp[0][0]);
        int i = 0, j = 0;
        System.out.println("选中 " + data[i][j]);
        for (i = 1; i < dp.length - 1; i++) {
            int value = dp[i - 1][j] - data[i - 1][j]; // 默认选中左边
            if (value == dp[i][j + 1]) { // 选中的是右边
                j++;
            }
            System.out.println("选中 " + data[i][j]);
        }
    }

    private static int[][] numberTower(int[][] data) {
        int N = data.length;
        int[][] dp = new int[N + 1][N + 1]; // 构造最底层的基层0,0,0,0,0
        for (int i = N - 1; i >= 0; i--) { // 从倒数第二层开始构建动态规划数组
            for (int j = 0; j <= i; j++) {
                // dp[i][j]代表从底层到改点的最大路径，
                dp[i][j] = (dp[i + 1][j] > dp[i + 1][j + 1] ? dp[i + 1][j] : dp[i + 1][j + 1]) + data[i][j];
            }
        }
        return dp;
    }
}
