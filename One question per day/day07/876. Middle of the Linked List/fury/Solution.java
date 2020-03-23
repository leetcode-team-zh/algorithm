class Solution {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }


    public ListNode middleNode(ListNode head) {
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            if (q == null || q.next == null) break;
            p = p.next;
            q = q.next.next;
        }
        return q == null ? p : p.next;

    }


    public static void main(String[] args) {


    }


}

