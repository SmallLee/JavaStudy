package com.lxn.test.leetcode;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Arrays;

/*
 * 从一个数组中查找和目标数最接近的或者相等的数 ,例如输入{3,5,2,1,6,9},target=3输出3，target=7,输出6
 * */
public class NearetNumInArr {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 6, 9};
        System.out.println(getNearstNumer(arr, 12));
    }

    private static int getNearstNumer(int[] arr, int target) {
        Arrays.sort(arr); // {1,2,3,5,6,9}
        int low = 0, high = arr.length - 1, mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);   //
            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // 边界检测
        if (low > arr.length - 1) {
            low = arr.length - 1;
        }
        if (high < 0) {
            high = 0;
        }
        System.out.println(high + "  " + low);
        int targetIndex;
        // 判断差值，high和low分别代表目标值的左右索引
        int highDiff = arr[high] - target;
        int lowDiff = arr[low] - target;
        if (Math.abs(highDiff) > Math.abs(lowDiff)) {
            targetIndex = low;
        } else {
            targetIndex = high;
        }
        return arr[targetIndex];
    }
}
