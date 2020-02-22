package com.lxn.test;

import javafx.scene.shape.FillRule;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 6, 9, 8};
        bubbleSoor(arr);
    }

    private static void bubbleSoor(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        /*
         * 等差数列求和 n*a1 + n(n-1)/2 * d
         * 上面循环次数为 (n-1) + (n-2) + ... 1 = n-1 + (n-1) (n-2)/2  = n(n-1) /2
         * 所以冒泡排序时间复杂度为O(n平方)
         * */
    }
}
