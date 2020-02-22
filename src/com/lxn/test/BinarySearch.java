package com.lxn.test;

import java.time.temporal.ValueRange;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(binarySearch(arr, 1));
    }

    private static int binarySearch(int[] arr, int target) {
        int low = 0,high = arr.length - 1,mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
