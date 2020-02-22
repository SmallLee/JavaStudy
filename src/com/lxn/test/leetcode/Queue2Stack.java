package com.lxn.test.leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*
 *  队列实现栈
 * */
class Queue2Stack<T> {
    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();
    private int size;

    void push(T element) {
        queue1.add(element);
        size++;
    }

    int size() {
        return size;
    }

    T pop() {
        T o = null;
        // q1前面的元素入队列2
       while (queue1.size() > 1) {
           queue2.add(queue1.poll());
       }
       if (queue1.size() == 1) {
           o = queue1.poll(); // 获取q1剩下元素
           while (queue2.size() > 0) {
               queue1.add(queue2.poll()); //q2剩下元素添加到q1
           }
       }
        return o;
    }
}
