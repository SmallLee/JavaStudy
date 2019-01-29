package com.lxn.test;

public class TestFinally {
    public static void main(String[] args) {
        System.out.println("=====方法开始");
        System.out.println(test());
        System.out.println("=====方法结束");
    }

    public static int test(){
        int i = 0;
        try {
            i ++;
            System.out.println("=====try开始");
            return i;
        }finally {
            System.out.println("=====finally开始");
            i -- ;
            System.out.println("=====finally结束");
        }
    }
}
