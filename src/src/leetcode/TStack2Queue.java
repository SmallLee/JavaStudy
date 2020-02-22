package leetcode;

import java.util.Stack;

public class TStack2Queue {
    public static void main(String[] args) {
        Stack2Queue s = new Stack2Queue();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        while (s.size() > 0) {
            System.out.println(s.poll());
        }
    }
}

/*
 * 思路：用两个栈实现
 * 入队时压入第一个栈，
 * 出队时出栈直到第一个栈剩一个元素，
 * */
class Stack2Queue<T> {
    private Stack<T> s1 = new Stack<>();
    private Stack<T> s2 = new Stack<>();

    int size() {
        return s1.size() + s2.size();
    }

    void add(T ele) {
        s1.push(ele);
    }

    T poll() {
        T o = null;
        if (s2.isEmpty()) {
            while (s1.size() > 1) {
                s2.push(s1.pop());
            }
            if (s1.size() == 1) {
                o = s1.pop();
            }
        } else {
            o = s2.pop();
        }
        return o;
    }
}