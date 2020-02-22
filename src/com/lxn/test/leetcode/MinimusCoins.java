package com.lxn.test.leetcode;

import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.net.SocketImpl;
import java.rmi.ConnectIOException;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ForkJoinPool;

/*
 *  组成某个值所需要的最少硬币
 *
 * */
public class MinimusCoins {

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        System.out.println(coins(coins, 2));
    }

    private static int coins(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1]; // 存储计算结果，+1是因为需要一个初始值0
        dp[0] = 0; // 初始化
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE; // 先将dp[i]初始为无穷大，进行对比
            for (int coin : coins) {
                // 凑足的金额一定得大于硬币的值并且减了硬币不应该等于无穷大
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE ) {
                    dp[i] = dp[i - coin] + 1;
                }
            }
            System.out.println(i + "元需要" + dp[i] + "个硬币");
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
