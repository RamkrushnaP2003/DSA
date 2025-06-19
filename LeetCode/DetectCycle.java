import java.awt.List;

public class DetectCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static int detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) {
                slow = head;
                while(slow!=fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast.val;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next = head.next.next;
        System.out.println(detectCycle(head));
    }
}
