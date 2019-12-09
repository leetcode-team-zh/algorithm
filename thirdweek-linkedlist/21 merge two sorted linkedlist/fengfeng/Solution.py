# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        p = ListNode(-1)
        pTail = p
        while l1 and l2:
            if l1.val > l2.val:
                pTail.next,pTail,l2= l2,l2,l2.next
            else:
                pTail.next,pTail,l1 = l1,l1,l1.next
        if l1 and not l2:
            pTail.next = l1
        else:
            pTail.next = l2

        return p.next
