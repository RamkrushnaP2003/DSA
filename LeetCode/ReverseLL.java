public class ReverseLL {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void reverseLL(ListNode head) {
        ListNode temp = head;
        recursion(temp);
        printLL(temp);
    }

    public static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp!=null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode recursion(ListNode curr) {
        if(curr.next == null || curr == null) {
            return curr;
        };
        ListNode head = recursion(curr.next);
        curr.next.next = curr;
        curr.next = null;
        return head;
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print original list
        System.out.print("Original List: ");
        printLL(head);

        // Reverse and print
        System.out.print("Reversed List: ");
        reverseLL(head);
    }
}
