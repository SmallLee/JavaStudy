package leetcode;

/*链表倒数第k个元素*/
public class LinkLastNode {
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
        System.out.println(getLastNode2(node1, 1).data);
    }

    /*双指针法*/
    private static Node getLastNode(Node head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        /*第一个指针先走k-1步*/
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        /*两个指针一起走，当前面的指针走到末尾的时候，后面的指针就是倒数第k个元素*/
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // 倒数第k个元素是正数第length - k + 1个元素，先得到链表长度，然后走leng-k+1不
    private static Node getLastNode2(Node head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        int length = 0;
        Node p = head;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        // 防止越界
        if (k > length) {
            return null;
        }
        for (int i = 0; i < length - k + 1; i++) {
            p = p.next;
        }
        return p;
    }
}
