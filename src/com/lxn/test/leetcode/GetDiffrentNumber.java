package com.lxn.test.leetcode;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.HashMap;

public class GetDiffrentNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        getDiffrentNumer(arr);
    }

    private static void getDiffrentNumer(int[] arr) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i != j && j != k && i != k) {
                        System.out.println(arr[i] + "" + arr[j] + "" + arr[k]);
                    }
                }
            }
        }
    }
}
