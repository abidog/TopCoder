package LinkedLists;

public class ReverseBetween {
    static class ListNode{
        ListNode next;
        int val;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);

        ReverseBetween rev = new ReverseBetween();
        rev.reverseBetween(l, 2,4);

    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        if (m == 1) {
            return reverse(head, n - m + 1);
        }
        ListNode runner = head;
        m--;
        while (runner.next != null && m-- > 1) {
            runner = runner.next;
        }


        runner.next = reverse(runner.next, n - m);
        return head;
    }

    public ListNode reverse(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;

        while (cur != null && n-- > 1) {
            cur.next = prev;
            prev = cur;
            cur = next;
            if (next != null)
                next = next.next;
        }
        head.next = cur;

        return prev;
    }
}
