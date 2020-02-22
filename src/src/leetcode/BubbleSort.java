package leetcode;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 2, 6, 8};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    private static int[] bubbleSort(int[] arr) {
        /*排序的趟数 ,N个数需要排N-1躺，因为N-1躺以后，最大的数就放在最后，无需排序了*/
        for (int i = 0; i < arr.length - 1; i++) {
            /*每趟比较多少次，每趟之后只需要比较剩下的次数*/
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
