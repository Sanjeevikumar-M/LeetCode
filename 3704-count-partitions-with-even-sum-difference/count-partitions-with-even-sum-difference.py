class Solution:
    def countPartitions(self, nums: List[int]) -> int:
        count = 0
        for i in range(1,len(nums)):
            n = sum(nums[:i]) - sum(nums[i:])
            if n%2==0:
                count+=1
        return count