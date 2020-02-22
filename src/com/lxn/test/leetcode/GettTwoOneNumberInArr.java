package com.lxn.test.leetcode;

import java.util.Arrays;
import java.util.Formatter;

/*
* 数组中有两个数出现了一次，其他数字都出现了两次，找出这两个数
* */
public class GettTwoOneNumberInArr {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3,4};
        System.out.println(Arrays.toString(getTwoOneNumberInArr(arr)));
        printAndResult();
    }
    /*
    * 0011
    * 0100 -- 异或后结果0111 & 1001
    * 7&-7
    * -7 = 1000。...0111
    * 1111.。。1000 -7的反码
    * 1111.。。1001 -7的补码
    * A & -B = A &  = A & (~(B - 1))
    * */
    private static int[] getTwoOneNumberInArr(int[] arr) {
        int AXORB = 0;
        for (int a : arr) {
            AXORB ^= a;
        }
        // 找到数字A和数字B中不相同的一位，并将该位置1，其他位置0
        int bitFlag = AXORB & (-AXORB); // 0001
        int[] res = new int[2];
        for (int a : arr) {
            if ((a & bitFlag) == 0) {
                res[0] ^= a;
            } else {
                res[1] ^= a;
            }
        }
        return res;
    }

    private static void printAndResult() {
        System.out.println(7&-7);
    }
}
