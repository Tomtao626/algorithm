package 链表;

/**
 * https://leetcode.cn/problems/remove-linked-list-elements/
 * @author tao626
 *
 */
public class _203_移除链表元素 {
	public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        if (head == null) return head;
        ListNode prev = head;
        ListNode last = head.next;
        while (last != null) {
        	if (last.val == val) {
        		prev.next = last.next;
        	} else {
        		prev = last;
        	}
        	last = last.next;
        }
        return head;
    }
}
