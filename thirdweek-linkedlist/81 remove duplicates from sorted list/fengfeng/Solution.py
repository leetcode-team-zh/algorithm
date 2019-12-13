# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        p = ListNode(-1)
        p.next,quick,slow = head,head,p
        while quick is not None:

            slow = quick
            quick = quick.next
            while quick is not None and quick.val == slow.val:
                quick = quick.next
            slow.next = quick
        return p.next
