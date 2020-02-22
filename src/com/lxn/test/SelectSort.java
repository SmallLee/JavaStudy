package com.lxn.test;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,6,9,8}; // 3,4,5689
        selectSort(arr);
    }
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i; // 最小索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (i != index) {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
