package linkedlist;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    static ListNode node1;

    static {
        ListNode node5 = new ListNode(5);

        ListNode node4 = new ListNode(4);
        node4.next = node5;

        ListNode node3 = new ListNode(3);
        node3.next = node4;

        ListNode node2 = new ListNode(2);
        node2.next = node3;

        node1 = new ListNode(1);
        node1.next = node2;
    }

    static ListNode nodeTwo;

    static {
        ListNode node5 = new ListNode(5);

        ListNode node4 = new ListNode(4);
        node4.next = node5;

        ListNode node3 = new ListNode(3);
        node3.next = node4;

        ListNode node2 = new ListNode(2);
        node2.next = node3;

        nodeTwo = new ListNode(1);
        nodeTwo.next = node2;
    }

}