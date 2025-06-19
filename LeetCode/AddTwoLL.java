public class AddTwoLL {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void addTwoLL(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0), temp1=l1, temp2=l2;
        ListNode ans = temp;
        int rem=0;
        while (temp1!=null || temp2!=null) {
            int sum = rem;
            if(temp1!=null) sum += temp1.val;
            if(temp2!=null) sum += temp2.val; 
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            rem = sum / 10;
            if(temp1!=null) temp1 = temp1.next;
            if(temp2!=null) temp2 = temp2.next;
        }
        printLL(ans.next);
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
        // Creating first linked list: 2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Creating second linked list: 5 -> 6 -> 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Adding the two linked lists
        addTwoLL(l1, l2);
    }
}
