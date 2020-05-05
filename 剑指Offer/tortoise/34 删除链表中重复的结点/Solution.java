package leetcode;

import common.ListNode;

public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        //哑节点
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode p1 = dummy;
        ListNode p2 = pHead;
        // -1->1->1->2->2->3->4->5->null
        while(p2 != null){
            if(p2.next != null && p2.next.val == p2.val){
                while(p2.next != null && p2.next.val == p2.val){
                    p2 = p2.next;
                }
                p1.next = p2.next;
            }else{
                p1 = p2;
            }
            p2 = p2.next;
        }

        return dummy.next;
    }
}