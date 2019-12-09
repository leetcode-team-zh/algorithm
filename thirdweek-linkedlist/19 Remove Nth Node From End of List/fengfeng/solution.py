# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        p = ListNode(-1)
        p.next = head;
        preN,current = p,p;
        while n>0 and current :
            current,n = current.next,n-1
        if not current:
            return head
        while current.next :
            current,preN= current.next,preN.next
        preN.next = preN.next.next
        return p.next
