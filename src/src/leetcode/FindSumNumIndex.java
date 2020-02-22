package leetcode;


import java.util.Arrays;
import java.util.HashMap;

public class FindSumNumIndex {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(getSumIndex(arr, 6)));
    }

    /*
     * 给定一个数组和一个整数，返回数组中两个数相加之和等于该数的索引
     * */
    private static int[] getSumIndex(int[] arr, int num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
            int com = num - arr[i];
            if (map.containsKey(com)) {
                return new int[]{map.get(com), i};
            }
        }
        return null;
    }
}
