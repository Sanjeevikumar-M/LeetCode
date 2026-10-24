# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def searchBST(self, root: TreeNode | None, val: int) -> TreeNode | None:
        if root==None: return None
        if root.val==val: return root
        n = root
        while n!=None:
            if n.val==val: return n
            elif n.val<val: n = n.right
            else: n = n.left
        return None