package com.lxn.test.leetcode;

import javax.management.Query;

public class TestQueue2Stack {
    public static void main(String[] args) {
        Queue2Stack<Integer> queue2Stack = new Queue2Stack<>();
        queue2Stack.push(1);
        queue2Stack.push(2);
        queue2Stack.push(3);
        queue2Stack.push(4);
        for (int i = 0; i < queue2Stack.size(); i++) {
            System.out.println(queue2Stack.pop());
        }
    }
}


