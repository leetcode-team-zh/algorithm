class Solution {
/*
*
* Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL*/

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode before = newHead;
        ListNode p = newHead;
        int count = 0;
        while (p != null) {
            before = p;
            p = p.next;
            count++;
            if (count == m) break;

        }

        while (count <= n && p != null) {
            stack.add(p);
            p = p.next;
            count++;
        }

        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            before.next = node;
            before = node;
        }

        before.next = p;
        return newHead.next;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->NULL
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution solution = new Solution();
        ListNode head = solution.reverseBetween(node1, 1, 5);
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + ", ");
            p = p.next;
        }

    }


}

