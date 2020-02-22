package com.lxn.test;

public class TestStaticFinal {
    public static void main(String[] args) {
//        System.out.println(Child.age); // 子类引用父类静态字段，不会初始化子类
    }
}

class Parent{
    static  int age = 10;
    static {
        System.out.println("parent static ");
        age = 20;
    }

}
class Child {
    static {
        System.out.println("Child static ");
    }
}
