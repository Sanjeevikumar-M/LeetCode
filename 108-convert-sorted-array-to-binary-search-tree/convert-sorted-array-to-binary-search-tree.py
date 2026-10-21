# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: list[int]) -> TreeNode | None:
        def buildtree(nums,left,right):
            if left>right:
                return None
            mid = left + (right-left)//2
            root = TreeNode(nums[mid])
            root.left = buildtree(nums,left,mid-1)
            root.right = buildtree(nums,mid+1,right)
            return root
        return buildtree(nums,0,len(nums)-1)