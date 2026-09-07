class Solution:
    def subarraySum(self, nums: List[int]) -> int:
        total = 0
        for i in range(0,len(nums)):
            start = max(0,i-nums[i])
            total += sum(nums[start:i+1])
        return total