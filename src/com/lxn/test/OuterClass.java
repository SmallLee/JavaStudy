package com.lxn.test;

import com.lxn.test.proxy.IMethod;
import sun.nio.cs.ext.MacThai;

public class OuterClass {
    private class InnerClass{
        int age;
    }
    static String str = "dfd";
    static int age = 2;
    private int getAge() {
        return new InnerClass().age;
    }
//    public static final String str ="wjrk1gycdidtoip31uaeMFvq1551615710wenjuantest06caaf5b6d9f8688081399e89b740274";
    public static void main(String[] args) {
//        OuterClass outerClass = new OuterClass();
//        // 不看代码的话不知道这个getAge的实现
//        int age = outerClass.getAge();
            String s = MD5Util.string2MD5(str);
//            transFormStrToNumer("123456");
        printNumer();
        }
        String number = "123";

    private static void transFormStrToNumer(String numStr) {
        int result = 0;
        char[] chars = numStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1) {
                result += chars[i] - '0';
            } else {
                result += (chars[i] - '0') * Math.pow(10,chars.length - i - 1);
            }
        }
        char c = '1' + '0';
        System.out.println('1' + '0'); // 97
        System.out.println(result);
    }

    private static void printNumer() {
        int number = 123456789;
        System.out.println(number / 1000 % 10000);
    }
}
