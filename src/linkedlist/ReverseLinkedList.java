package linkedlist;

/**
 * 206. 反转链表
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @author gaoyh
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        printLinkedList(reverse(ListNode.node1));
    }

    private static ListNode reverse(ListNode now) {
        ListNode prev = null;
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
