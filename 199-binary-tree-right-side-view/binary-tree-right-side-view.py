# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode | None) -> list[int]:
        l = []
        def helper(node,depth):
            if node!=None:
                if depth==len(l):
                    l.append(node.val)
                helper(node.right,depth+1)
                helper(node.left,depth+1)
        helper(root,0)
        return l