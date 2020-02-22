package leetcode;

/*删除排序链中重复元素元素*/
public class DeleteRepeatNodeElement {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(4);
        Node node6 = new Node(4);
        Node node7 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        Node node = deleteRepeatNode(node1);
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    private static Node deleteRepeatNode(Node head) {
       /* if (head == null || head.next == null) {
            return head;
        }
        *//*添加一个头节点，防止出现第一，第二个相同的情况，
        删除以后无法获取后面的节点*//*
        Node first = new Node(0);
        first.next = head;
        // pre指向确定不重复的结点
        Node prev = first;
        Node last = head;
        while (last != null) {
            // 如果last和后面节点相同
            if (last.next != null && last.data == last.next.data) {
                // //找到last往后不重复的结点的位置 0-1-2-3-3-4-4-5
                while (last.next != null && last.data == last.next.data) {
                    last = last.next;
//                    System.out.println(last.data);// 3,4
                }
                // 相当于删除重复的点
                prev.next = last.next;
                last = last.next;
            } else {
                // 不重复 prev和last往后移
                prev = prev.next;
                last = last.next;
            }
        }*/
        if (head == null || head.next == null) {
            return head;
        }
        /*添加一个头结点，防止出现第一，第二个节点相同情况*/
        Node first = new Node(0);
        first.next = head;
        Node prev = first;
        Node last = head;
        while (last != null) {
            if (last.next != null && last.data == last.next.data) {
                // 找到不重复的最后一个节点
                while (last.next != null && last.data == last.next.data) {
                    last = last.next;
                }
                // 相当于删除节点
                prev.next = last.next;
                last = last.next;
            } else {
                // 没有重复的，指针移动
                prev = prev.next;
                last = last.next;
            }
        }
        return first.next;
    }
}
