package com.lxn.test.leetcode;


/*
 *  两个链表的公共节点
 * */
public class PublicNode {
    static class Node<T> {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node head2 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        head2.next = node7;
        node7.next = node8;
        node8.next = node9;
//        node9.next = node5;
        Node publicNode = getPublicNode(head1, head2);
        System.out.println(publicNode == null ? null : publicNode.data);
    }

    private static Node getPublicNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int length1 = getNodeLength(head1);
        int length2 = getNodeLength(head2);
        int diff = length1 - length2; // 默认链表1比链表2长
        Node headLong = head1; // 长链表头
        Node headShort = head2; // 短链表头
        if (diff < 0) {
            diff = -diff;
            headLong = head2;
            headShort = head1;
        }
        for (int i = 0; i < diff; i++) {
            headLong = headLong.next;
        }
        System.out.println(headShort.data + "--" + headLong.data);
        while (headLong.next != null && headShort.next != null) {
            headLong = headLong.next;
            headShort = headShort.next;
            if (headShort == headLong) {
                return headLong;
            }
        }
        return null;
    }

    // 获取链表长度
    private static int getNodeLength(Node head) {
        int length = 0;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
