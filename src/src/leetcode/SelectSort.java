package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 2, 6, 8};
        List<Object> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        System.out.println(Arrays.toString(selectSort(arr)));
    }

    /*每次从数组中选出最小的元素，放在数组起始位置，直到所有的元素排完*/
    private static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
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
        return arr;
    }
}
