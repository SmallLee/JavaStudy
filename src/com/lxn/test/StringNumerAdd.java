package com.lxn.test;

// String字符串的数字相加
public class StringNumerAdd {
    public static void main(String[] args) {
        String s = "12345";
        int result = 0;
        for (char c : s.toCharArray()) {
            System.out.println(c+'0');
            result += c - '0';
        }
        System.out.println(result);
    }
}
