package com.lxn.test.leetcode;

import javax.management.ListenerNotFoundException;

public class GetEndKNode {
    static class Node<T>{
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node nodeFromEnd = getNodeFromEnd(node,1);
        System.out.println(nodeFromEnd == null ? null : nodeFromEnd.data);
    }

    // 双指针法，定义两个指针，第一个指针走k-1步，然后两个指针一起走，当第一个指针走到
    // 尾部的时候，第二个指针就指向倒数第k个元素，因为两个指针之间的间距是k - 1
    private static Node getNodeFromEnd(Node head,int k) {
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k - 1; i++) {
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                return null;
            }
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    // 单指针法，倒数第k个元素就是正数第length - k + 1个元素，其中length为链表的长度
    // 先计算链表的长度，然后让一个指针走length-k+1步即可

}
