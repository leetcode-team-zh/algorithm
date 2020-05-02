package leetcode;


import common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        //1-> 2-> 3 -> 4 -> 5-> 6 -> null
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && k > 0){
            fast = fast.next;
            k--;
        }

        if(fast == null & k > 0){
            return null;
        }


        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        new Solution().FindKthToTail(l1,5);
    }
}
