package com.lxn.test;

public class TestStatic {
    public static void main(String[] args){
        AVGirl girl1 = new AVGirl();
        girl1.name = "苍老师";
        AVGirl.country = "日本";
//        girl1.sayHi();

        AVGirl girl2 = new AVGirl();
        girl2.name = "波多老师";
        AVGirl.country = "北海道";
        girl1.sayHi();
    }
}
class AVGirl{
    String name;  //姓名
    static String country;  //国籍

    public void sayHi(){
        System.out.println("姓名为:" + name);
        System.out.println("国籍为:" + country);
    }
}
