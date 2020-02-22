package com.lxn.test.leetcode;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import javax.sound.midi.Soundbank;
import java.util.Enumeration;
import java.util.Stack;

/*
 *  栈实现队列
 * */
class Stack2Queue<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();
    private int size;

    // 队列尾部添加
    void add(T element) {
        stack1.push(element);
        size++;
    }

    // 队列长度
    int size() {
        return size;
    }

    // 获取并删除头部元素
    T poll() {
        T o = null;
        if (stack2.isEmpty()) {
            while (stack1.size() > 1) {
                stack2.push(stack1.pop());
            }
            if (stack1.size() == 1) {
                o = stack1.pop();
            }
        } else {
            o = stack2.pop();
        }
        return o;
    }

    // 获取头部元素不删除
    T peek() {
        T o = null;
        while (stack1.size() > 1) {
            stack1.pop();
        }
        if (stack1.size() == 1) {
            o = stack1.peek();
        }
        return o;
    }
}
