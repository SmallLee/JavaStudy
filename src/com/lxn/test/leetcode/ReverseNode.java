package com.lxn.test.leetcode;

public class ReverseNode {
    static class Node<T>{
        T data;
        Node next;
        Node(T data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4= new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node reverseNode = reverseNode2(node);
        while (reverseNode != null) {
            System.out.println(reverseNode.data);
            reverseNode = reverseNode.next;
        }
    }

    // 双指针法
    private static Node reverseNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head.next;
        Node pre = head;
        while (cur != null) {
            Node nextTemp = cur.next;
            cur.next = pre; // 节点翻转
            pre = cur; // 指针向下走
            cur = nextTemp;
        }
        // 原头结点的指针域置null.并且返回新的头节点
        head.next = null;
        return pre;
    }

    // 递归法
    /*
    * 1-2-3-4-5
    * 假设head=4,此时执行reverseNode2(head.next),head.next =5,然后开始出栈
    * 第一次出栈，执行temp.next = head;即5—4，4-null
    * 第二次出栈，4-3,3-null
    * 最后一次出栈，2-1,1-null
    * */
    private static Node reverseNode2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node reHead = reverseNode2(head.next);
        Node temp = head.next;
        temp.next = head;
        head.next = null;
        return reHead;
    }
}
