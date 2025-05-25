public class RemoveNthNodeFromEnd {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // step 1 -> count LL size 
    // if n == count return head.next
    // remove (count - n)th node from ll

    public static void removeNthNodeFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for(int i=0; i<n; i++) {
            fast = fast.next;
        }
        if(fast==null) {
            head = head.next; 
            printLL(head);
            return;
        }
        printLL(fast);
        ListNode slow = head;
        ListNode ans = slow;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        printLL(head);
    }

    public static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp!=null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= 10; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        removeNthNodeFromEnd(head, 4);
    }
}
