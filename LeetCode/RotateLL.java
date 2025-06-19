public class RotateLL {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void rotate(ListNode head, int k) {
        int count = 1;
        ListNode temp = head, temp2 = head;
        while (temp.next!=null) {
            count++;
            temp = temp.next;
        }
        k = k % count;
        if(k==0) {
            printLL(head); return;
        }
        temp.next = head;
        ListNode newHead = getNewHead(head, count - k);
        head = newHead.next;
        newHead.next = null;
        printLL(head);
    }

    public static ListNode getNewHead(ListNode head, int k) {
        int count = 1;
        while (head!=null) {
            if(count==k) return head;
            head = head.next;
        }
        return head;
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
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        rotate(head, 2);
    }
}
