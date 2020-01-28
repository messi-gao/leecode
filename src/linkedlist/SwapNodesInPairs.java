package linkedlist;

/**
 * \24. 两两交换链表中的节点
 *
 * @author gaoyh
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        printLinkedList(swapNodesInPairs(ListNode.node1));
    }

    private static ListNode swapNodesInPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
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
