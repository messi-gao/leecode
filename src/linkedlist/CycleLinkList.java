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
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
