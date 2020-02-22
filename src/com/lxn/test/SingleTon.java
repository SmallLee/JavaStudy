package com.lxn.test;

import java.io.FileInputStream;

public class SingleTon {
    private SingleTon(){};

    /* DLC
    private static volatile SingleTon instace;

    public static SingleTon getInstace() {
        if (instace == null) {
            synchronized (SingleTon.class) {
                if (instace == null) {
                    instace = new SingleTon();
                }
            }
        }
        return instace;
    }*/
    /*
    * 静态内部类
    * */
    private static class SingleTonHolder{
        private static final SingleTon INSTACE = new SingleTon();
    }

    public static SingleTon getInstance() {
        return SingleTonHolder.INSTACE;
    }
}
