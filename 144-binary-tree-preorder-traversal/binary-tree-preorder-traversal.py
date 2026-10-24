# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: TreeNode | None) -> list[int]:
        l = []
        def helper(node):
            if node!=None:
                l.append(node.val)
                helper(node.left)
                helper(node.right)
        helper(root)
        return l