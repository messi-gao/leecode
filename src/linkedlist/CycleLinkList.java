package linkedlist;

/**
 * 141. 环形链表
 *
 * @author gaoyh
 */
public class CycleLinkList {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
//        node5.next = node5;

        ListNode node4 = new ListNode(4);
        node4.next = node5;

        ListNode node3 = new ListNode(3);
        node3.next = node4;

        ListNode node2 = new ListNode(2);
        node2.next = node3;

        ListNode node1 = new ListNode(1);
        node1.next = node2;

        System.out.println(hasCycle(node1));
    }


    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
