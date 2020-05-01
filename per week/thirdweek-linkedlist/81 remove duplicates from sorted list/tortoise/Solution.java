package leetcode.d82;

import common.ListNode;

import java.util.List;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        //增加一个链表头
        ListNode pre = new ListNode(-1);
        pre.next = head;

        //快慢指针
        ListNode fast = head;
        ListNode slow = pre;

        //*->1->2->3->3->4->4->5
        while (fast != null){
            while(fast.next != null && fast.val == fast.next.val){
                fast = fast.next;
            }
            if(slow.next != fast){
                slow.next = fast.next;
            }else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node33 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node44 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node33;
        node33.next = node4;
        node4.next = node44;
        node44.next = node5;
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(1);
//        ListNode node3 = new ListNode(1);
//        ListNode node33 = new ListNode(2);
//        ListNode node4 = new ListNode(2);
//        ListNode node44 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
 //       node1.next = node2;
//        node2.next = node3;
//        node3.next = node33;
//        node33.next = node4;
//        node4.next = node44;
//        node44.next = node5;

        new Solution().deleteDuplicates(node1);
    }
}
