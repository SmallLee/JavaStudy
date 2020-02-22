package com.lxn.test;

import java.util.Timer;

public class TestVolatile {
    private volatile int a = 1;
    public static void main(String[] args) {
        TestVolatile testVolatile = new TestVolatile();
        testVolatile.start();
    }

    public void start() {
        new Thread(){
            @Override
            public void run() {
                a++;
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                a = a -2;
            }
        }.start();;
        new Thread(){
            @Override
            public void run() {
                a--;
            }
        }.start();;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
       /* while (true) {
            System.out.println(Thread.activeCount());
        }*/
    }
}
