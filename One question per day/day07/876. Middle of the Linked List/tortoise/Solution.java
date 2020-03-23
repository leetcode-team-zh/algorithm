package leetcode.d876;

import common.ListNode;

public class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null ) {
            return head;
        }
        //亚节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        //快慢指针
        ListNode fastNode = dummyNode;
        ListNode slowNode = dummyNode;

        while(fastNode != null){
            slowNode = slowNode.next;
            if(fastNode.next == null){
                break;
            }
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        //listNode5.next = listNode6;
        ListNode listNode = new Solution().middleNode(listNode1);
        System.out.println(listNode);
    }
}
