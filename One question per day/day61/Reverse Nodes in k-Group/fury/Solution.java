public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode first = head;
        ListNode p = head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        int num = 1;
        while (p != null) {
            p = p.next;
            if (p != null)
                num++;
            if (num == k && p!=null) {
                ListNode last = p.next;
                ListNode q = p.next;
                ListNode nextPre = first;
                while (first != p) {
                    ListNode node = first;
                    first = first.next;
                    node.next = q;
                    p.next = node;
                    q = node;
                }
                pre.next = p;
                first = last;
                p = first;
                pre = nextPre;
                num = 1;


            }
        }
        return newHead.next;
    }
