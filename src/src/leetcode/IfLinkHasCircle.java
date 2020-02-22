package leetcode;

import java.security.acl.LastOwnerException;

public class IfLinkHasCircle {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;
        System.out.println(hasCircle(node1));
    }

    /*判断链表是否有环*/
    private static boolean hasCircle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        Node meetNode = null;
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meetNode = fast;
                break;
            }
        }
        // meetNode不为空，说明有环，求环中节点个数
        if (meetNode != null) {
            Node temp = meetNode;
            int nodeCount = 1;
            while (temp != meetNode.next) {
                meetNode = meetNode.next;
                nodeCount++;
            }
            System.out.println("环中节点个数为" + nodeCount);
            /*
             * 求环的入口，
             * 让slow指针回到链表头部，fast在相遇的地方，两个指针一起走，当它们
             * 相遇的时候，就是链表环的入口
             * */
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            System.out.println("环的入口为" + slow.data);
        }
        return meetNode != null;
    }
}
