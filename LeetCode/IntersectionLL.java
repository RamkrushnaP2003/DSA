import java.util.HashMap;

public class IntersectionLL {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void intersection(ListNode head1, ListNode head2) {
        ListNode temp1 = head1, temp2 = head2;
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (temp1!=null) {
            map.put(temp1, map.getOrDefault(temp1, 0)+1);
            temp1 = temp1.next;
        }
        while (temp2!=null) {
            if(map.containsKey(temp2)) {
                printLL(temp2);
                return;
            }
            temp2 = temp2.next;
        }
        System.out.println("404");
    }

    public static void intersection2(ListNode headA, ListNode headB) {
        int countHeadA = countLLLength(headA);
        int countHeadB = countLLLength(headB);
        ListNode temp1 = countHeadA >= countHeadB ? headA : headB;
        ListNode temp2 = countHeadA >= countHeadB ? headB : headA;
        for(int i=0; i<Math.abs(countHeadA-countHeadB); i++) {
            temp1 = temp1.next;
        }
        while (temp1 != null && temp2!=null) {
            if(temp1 == temp2) {
                printLL(temp1);
                return;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return ;
    }

    public static int countLLLength(ListNode head) {
        ListNode temp = head;
        int count=0;
        while (temp!=null) {
            count++;
            temp = temp.next;
        }
        return count;
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
        // Create first linked list: 1 -> 2 -> 3 \
        //                                  ↘
        //                                    6 -> 7
        //                                  ↗
        //                4 -> 5 ----------/
        // Create intersection node
        ListNode intersect = new ListNode(6);
        intersect.next = new ListNode(7);

        // First list: 1 -> 2 -> 3 -> 6 -> 7
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = intersect;

        // Second list: 4 -> 5 -> 6 -> 7
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = intersect;

        intersection2(head1, head2);
    }
}
