package leetcode;


import common.ListNode;

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int p1Length = 0 ;
        int p2Length = 0 ;
        ListNode tmpHead1 = pHead1;
        ListNode tmpHead2 = pHead2;

        while(tmpHead1 != null){
            p1Length ++;
            tmpHead1 = tmpHead1.next;
        }

        while(tmpHead2 != null){
            p2Length ++;
            tmpHead2 = tmpHead2.next;
        }

        int step = p2Length - p1Length;
        if(step >= 0){
            while(step > 0 && pHead2 != null){
                pHead2 = pHead2.next;
            }
        }else{
            step = -step;
            while(step > 0 && pHead1 != null){
                pHead1 = pHead1.next;
                step -- ;
            }
        }

        while(pHead2 != null && pHead1 != pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return pHead1;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        l3.next = l6;
        l6.next = l7;

        new Solution().FindFirstCommonNode(l1,l4);
    }
}
