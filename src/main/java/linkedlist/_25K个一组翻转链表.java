package linkedlist;

public class _25K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;

        int i;
        for (ListNode cur, p; ; pre = p) {
            for (i = 1, cur = pre.next, p = pre.next; i < k && cur != null; i++, cur = cur.next);
            if (i != k || cur == null) break;
            ListNode post = cur.next;
            while (p.next != post) {
                ListNode t = p.next;
                p.next = t.next;
                t.next = pre.next;
                pre.next = t;
            }
        }
        return dummy.next;
    }
}
