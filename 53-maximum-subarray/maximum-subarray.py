class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        n = len(nums)
        if n==1:
            return nums[0]
        curr = nums[0]
        m = nums[0]
        for i in range(1,n):
            curr = max(curr+nums[i],nums[i])
            m = max(m,curr)
        return m