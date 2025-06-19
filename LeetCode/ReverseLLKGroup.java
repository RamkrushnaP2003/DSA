public class ReverseLLKGroup {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // public static void reverseLLKGroup(ListNode head, int k) {
    //     ListNode temp = head, kThNode, nextNode;
    //     ListNode first = temp;
    //     int count=1;
    //     while (temp!=null) {
    //         count++;
    //         if(count==k) {
    //             nextNode = temp.next;
    //             temp.next = null;
    //             reverse(first);
    //         }
    //         temp = temp.next;
    //     }
    // }

    private static ListNode reverse(ListNode head) {
        ListNode prev=null, curr=head, next;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void reverseLLKGroup(ListNode head, int k) {
        ListNode temp=head, nextNode, prevNode=null;
        while (temp!=null) {
            ListNode kThNode = getKThNode(temp, k);
            if(kThNode==null) {
                if(prevNode !=null) {
                    prevNode.next = temp;
                }
                break;
            }
            nextNode = kThNode.next;
            kThNode.next = null;
            reverse(temp);
            if(temp == head) {
                head = kThNode;
            } else {
                prevNode.next = kThNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
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

    public static ListNode getKThNode(ListNode temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        reverseLLKGroup(head, 2);
    }
}