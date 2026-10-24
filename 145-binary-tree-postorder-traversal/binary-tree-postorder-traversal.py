# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: TreeNode | None) -> list[int]:
        l = []
        def helper(node):
            if node!=None:
                helper(node.left)
                helper(node.right)
                l.append(node.val)
        helper(root)
        return l