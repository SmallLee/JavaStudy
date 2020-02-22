package com.lxn.test;

import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.awt.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {
    public static void main(String[] args) {
        /* 当前线程组中所有的线程名称
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        int count = threadGroup.activeCount();
        Thread[] threads = new Thread[count];
        threadGroup.enumerate(threads);
        for (Thread t : threads) {
            System.out.println(t.getName());
        }*/
        PrintTask task = new PrintTask();
        ThreadGroup threadGroup = new ThreadGroup("task");
        Thread a = new Thread(threadGroup,"A") {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                    task.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread b = new Thread(threadGroup,"B") {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(10000);
                    task.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread c = new Thread(threadGroup,"C") {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(8000);
                    task.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread d = new Thread() {
            @Override
            public void run() {
                super.run();
                task.printD();
            }
        };
        a.start();
        b.start();
        c.start();
        while (true) {
            if (threadGroup.activeCount() == 2) {
                d.start();
                break;
            }
        }
    }


    static class PrintTask {
        public void printA() {
            System.out.println("A");
        }


        public void printB() {
            System.out.println("B");
        }


        public void printC() {
            System.out.println("C");
        }

        public void printD() {
            System.out.println("D");
        }
    }
}
