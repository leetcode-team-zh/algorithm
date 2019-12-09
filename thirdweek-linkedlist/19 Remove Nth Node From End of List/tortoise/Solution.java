package leetcode.d19;

import common.ListNode;

import java.util.List;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0){
            return head;
        }
        ListNode first = head;
        ListNode second = head;

        for(int i = 0; i < n ; i++){
            first = first.next;
        }

        if(first == null){
            return head.next;
        }

        while (first.next != null){
            first = first.next;
            second = second.next;
        }

        //删除
        second.next = second.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        new Solution().removeNthFromEnd(node1,1);
    }
}
