
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if head is None:
            return head
        node,count = head,1
        while node.next is not None:
            count = count + 1
            node = node.next
        k = k % count
        node.next,node = head,head;
        for i in range(count - k - 1):
            node = node.next
        head = node.next
        node.next = None
        return head
