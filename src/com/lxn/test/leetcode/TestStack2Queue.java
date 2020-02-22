package com.lxn.test.leetcode;

import javax.xml.bind.SchemaOutputResolver;

public class TestStack2Queue {
    public static void main(String[] args) {
        Stack2Queue<Integer> queue = new Stack2Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.peek());
        }
    }
}
