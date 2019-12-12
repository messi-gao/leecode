package linkedlist;

/**
 * 206. 反转链表
 *
 * @author gaoyh
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        printLinkedList(reverse(ListNode.node1));
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode now = head;
        while (now != null) {
            ListNode next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }
        return prev;
    }

    private static void printLinkedList(ListNode node) {
        System.out.println(node.val);
        ListNode nextNode = node.next;
        while (nextNode != null) {
            System.out.println(nextNode.val);
            nextNode = nextNode.next;
        }
    }
}
