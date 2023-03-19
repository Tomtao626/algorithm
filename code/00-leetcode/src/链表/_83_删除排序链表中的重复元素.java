package 链表;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * @author tao626
 *
 */
public class _83_删除排序链表中的重复元素 {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (slow.val == fast.val) {
                fast = fast.next;
            } else {
                slow.next = fast;
                slow = slow.next;
            }
        }
        slow.next = null;
        return head;
    }
}
