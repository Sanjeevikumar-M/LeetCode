class Solution:
    def pivotIndex(self, nums: list[int]) -> int:
        for i in range(len(nums)):
            ls = sum(nums[:i])
            rs = sum(nums[i+1:])
            if ls==rs:
                return i
        return -1