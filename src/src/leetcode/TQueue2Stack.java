package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TQueue2Stack {
    public static void main(String[] args) {
        Queue2Stask<Integer> stack = new Queue2Stask<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}

/*思路：
 * 用两个队列来实现，
 * 添加元素时向第一个队列添加，
 * 移除元素时先依次将第一个队列的元素出栈添加到队列2直至剩最后一个元素，
 * 然后将第二个队列的元素依次出队列，添加到队列一，
 * 这样就实现了原来队列中先入队的元素放到了队列后面
 * */
class Queue2Stask<T> {
    private Queue<T> q1 = new LinkedList<>();
    private Queue<T> q2 = new LinkedList<>();

    int size() {
        return q1.size();
    }

    void push(T ele) {
        q1.add(ele);
    }

    /*T pop() {
        T o = null;
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        if (q1.size() == 1) {
            o = q1.poll();
            while (q2.size() > 0) {
                q1.add(q2.poll());
            }
        }
        return o;
    }*/
    T pop() {
        T o = null;
        /*将队列1中除了最后一个元素外全部添加到队列2*/
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        if (q1.size() == 1) {
            o = q1.poll();
            /*将队列2中的元素依次添加到队列1*/
            while (q2.size() > 0) {
                q1.add(q2.poll());
            }
        }
        return o;
    }

}
