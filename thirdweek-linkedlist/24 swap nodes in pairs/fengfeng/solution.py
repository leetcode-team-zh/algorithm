# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        p = ListNode(-1)
        tail,first = p,head
        while first is not None:
            second = first.next
            if second is None:
                tail.next = first
                tail = first
                break
            head = second.next
            tail.next = second
            second.next = first
            tail = first
            first = head
        tail.next = None
        return p.next
        
            
            
