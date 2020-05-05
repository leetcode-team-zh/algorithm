package leetcode;

import common.ListNode;

public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return null;
        }

        //快慢指针
        ListNode slow = pHead;
        ListNode fast = pHead;

        while(true){
            if(fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }else{
                return null;
            }
            if(fast == slow){
                break;
            }
        }

        //一个指针从头走
        slow = pHead;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}