# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        curr = dummy
        c = 0
        while l1 or l2 or c>0:
            v1 = l1.val if l1 else 0
            v2 = l2.val if l2 else 0
            s = v1+v2+c
            curr.next = ListNode(s%10)
            curr = curr.next
            c = s//10
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
        return dummy.next