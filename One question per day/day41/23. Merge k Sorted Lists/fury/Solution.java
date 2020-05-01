class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o2.val - o1.val; // 降序
            }
        });

        for (ListNode p : lists) {
            while (p != null) {
                queue.offer(p);
                p = p.next;
            }
        }

        while (!queue.isEmpty()) {
            ListNode p = queue.poll();
            p.next = head.next; // 头插法
            head.next = p;
        }


        return head.next;
    }

    static ListNode construct(int[] nums) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int i : nums) {
            ListNode q = new ListNode(i);
            p.next = q;
            p = q;
        }
        return head.next;

    }

    static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + ", ");
            p = p.next;
        }
    }

    //[
    //  1->4->5,
    //  1->3->4,
    //  2->6
    //]
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 5};
        int[] nums2 = {1, 3, 4};
        int[] nums3 = {2, 6};
        ListNode head1 = construct(nums1);
        ListNode head2 = construct(nums2);
        ListNode head3 = construct(nums3);
        ListNode[] lists = {head1, head2, head3};

        Solution solution = new Solution();
        ListNode head = solution.mergeKLists(lists);
        printList(head);
    }
