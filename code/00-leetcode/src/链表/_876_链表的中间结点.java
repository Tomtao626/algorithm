package 链表;

/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 * @author tao626
 *
 */

public class _876_链表的中间结点 {
	public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
