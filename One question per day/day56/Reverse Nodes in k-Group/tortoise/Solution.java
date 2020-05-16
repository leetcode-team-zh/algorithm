package leetcode.d25;

import common.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //-1->1->2->3->4->5->6->7->8
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while(end.next != null){
            for(int i = 0; i < k && end != null ; i++){
                end = end.next;
            }

            if(end == null){
                break;
            }

            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reserve(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reserve(ListNode root){
        ListNode pre = null;
        ListNode curr = root;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1= new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3= new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5= new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        new Solution().reverseKGroup(l1,2);
    }
}
