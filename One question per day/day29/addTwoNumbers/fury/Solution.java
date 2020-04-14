static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 思路：先整成数字，再去按位生成链表
        String numA = generateNum(l1);
        String numB = generateNum(l2);
        String sum = addNum(numA, numB);
        ListNode head = new ListNode(0);
        char[] chs = sum.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            ListNode p = new ListNode(chs[i] - '0');
            p.next = head.next;
            head.next = p;
        }
        return head.next;
    }

    private String addNum(String num1, String num2) {
        int carry = 0;
        int index = 0;
        StringBuilder res = new StringBuilder();
        int min = Math.min(num1.length(), num2.length());
        while (index < min) {
            int sum = num1.charAt(index) - '0' + num2.charAt(index) - '0' + carry;
            res.append(sum % 10);
            carry = sum / 10;
            index++;
        }

        while (index >= num2.length() && index < num1.length()) {
            int sum = num1.charAt(index) - '0' + carry;
            res.append(sum % 10);
            carry = sum / 10;
            index++;
        }
        while (index >= num1.length() && index < num2.length()) {
            int sum = num2.charAt(index) - '0' + carry;
            res.append(sum % 10);
            carry = sum / 10;
            index++;
        }
        if (carry != 0) res.append(carry);

        return res.toString();
    }

    private String generateNum(ListNode head) {
        StringBuilder res = new StringBuilder();
        if (head == null) return res.toString();
        ListNode p = head;
        while (p != null) {
            res.append(p.val);
            p = p.next;
        }
        return res.reverse().toString();
    }
