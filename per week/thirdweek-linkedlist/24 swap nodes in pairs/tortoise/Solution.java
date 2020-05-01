package leetcode.d24;

import common.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        //增加一个前置节点
        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode curr = pre;

        //*->1-> 2->3
        //curr *
        while(curr.next != null && curr.next.next != null){
            ListNode node1 = curr.next; //1
            ListNode node2 = curr.next.next; //2

            node1.next = node2.next; // 1->3
            node2.next = node1; // 2->1->3
            curr.next = node2; // * -> 2 -> 1 -> 3

            curr = node1; // 1
        }
        return  pre.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        new Solution().swapPairs(node1);
    }
}
