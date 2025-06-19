public class CopyLLwithRandom {
    static class ListNode {
        int val;
        ListNode next, random;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void copyLL(ListNode head) {
        ListNode temp = head;
        while (temp!=null) {
            ListNode newTemp = temp.next;
            temp.next = new ListNode(temp.val);
            temp.next.next = newTemp;
            temp = temp.next.next;
        }

        temp = head;
        while (temp!=null) {
            ListNode res = temp.next;
            if(temp.random != null) {
                res.random = temp.random.next;
            } else {
                res.random = null;
            }
            temp = temp.next.next;
        }
        
        temp = head;
        ListNode ans = new ListNode(-1);
        ListNode res = ans;
        while (temp!=null) {
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
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
        temp = head;
        while (temp!=null) {
            System.out.print((temp.random==null) ? "null " : temp.random.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        ListNode node2 = new ListNode(13);
        ListNode node3 = new ListNode(11);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(1);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head.random = null;
        node2.random = head;
        node3.random = node5;
        node4.random = node3;
        node5.random = head;
        copyLL(head);
    }
}
