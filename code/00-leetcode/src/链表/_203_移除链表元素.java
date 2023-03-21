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
        ListNode node = head.next;
        while (node != null) {
            if (node.val == val) {
                prev.next = node.next;
            } else {
                prev = node;
            }
            node = node.next;
        }
        return head;
    }
}
