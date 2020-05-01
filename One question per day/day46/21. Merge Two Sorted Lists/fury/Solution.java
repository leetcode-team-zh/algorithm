public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = l1;
        ListNode q = l2;
        ListNode node = head;
        while (p != null && q != null) {
            if (p.val < q.val) {
                node.next = p;
                node = p;
                p = p.next;
            } else {
                node.next = q;
                node = q;
                q = q.next;
            }
        }

        if (p != null) node.next = p;
        if (q != null) node.next = q;

        return head.next;
    }
