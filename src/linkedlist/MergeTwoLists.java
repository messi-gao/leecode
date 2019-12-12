package linkedlist;

/**
 * 21. 合并两个有序链表
 *
 * @author gaoyh
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        ListNode prev = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new MergeTwoLists().mergeTwoLists(ListNode.node1, ListNode.nodeTwo);
        printLinkedList(listNode);
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
