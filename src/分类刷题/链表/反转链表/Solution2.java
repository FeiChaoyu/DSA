package 分类刷题.链表.反转链表;

/**
 * 反转链表前n个节点
 */
public class Solution2 {

    /**
     * 后驱节点
     */
    private ListNode successor = null;

    public ListNode reverseList(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        return reverseN(head, n);
    }

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode newHead = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return newHead;
    }
}
