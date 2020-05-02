package leetcode;


import common.ListNode;

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode next = head.next;
        head.next = null;
        while(next != null){
            ListNode tmp = next.next;
            next.next = head;
            head = next;
            next = tmp;
        }
        return head;
    }
}
