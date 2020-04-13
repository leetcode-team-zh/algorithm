package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/13 9:47 下午
 **/
public class addTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if(l1==null||l2==null)
            return null;
        ListNode  head = new ListNode(0);
        ListNode pre = head;
        int sum =0;
        while(l1 !=null || l2!=null){
            if(l1!=null){
                sum+=l1.val;
                l1 =l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(sum%10);
            sum/=10;
            pre = pre.next;
        }
        if(sum!=0){
            pre.next = new ListNode(1);
        }
        return head.next;
    }
   }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        node1.next = null;
        node2.next = node3;
        node3.next = null;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);

        node4.next = null;
        node5.next = null;

//        node6.next = null;

        ListNode res =new addTwoNumbers_2().addTwoNumbers(node1,node4);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}

