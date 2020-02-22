package leetcode;

/*删除链表指定元素*/
public class DeleteNodeElement {
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
        Node node = deleteNodeEle(node1, 3);
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    private static Node deleteNodeEle(Node head, int value) {
        if (head == null) {
            return head;
        }
        if (head.data == value) {
            head = head.next;
            return head;
        }
        // 指向头节点的指针
        Node p = head;
        while (p.next != null) {
            if (p.next.data == value) {
                p.next = p.next.next;
                break;
            }
            /*移动指针*/
            p = p.next;
        }
        return head;
    }
}
