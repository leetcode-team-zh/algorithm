package leetcode.d61;

import common.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }

        //1.先找到最后一个，将其指针指向头节点，并计算出长度
        ListNode curr = head;
        int length = 1;
        while (curr.next != null){
            length ++;
            curr = curr.next;
        }


        //利用快慢指针找到倒数第k，k可能超过length，故需要取模
        k = k % length;
        if(k == 0){
            //不需要移动
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(k -- > 0 ){
            fast = fast.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode result = slow.next;
        curr.next = head;
        slow.next = null;
        return result;
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
        new Solution().rotateRight(node1,2);
    }
}
