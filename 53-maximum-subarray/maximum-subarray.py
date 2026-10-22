class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        n=len(nums)
        maxi=float("-inf")
        total=0

        for i in nums:
            total=total+i
            if maxi<total:
                maxi=total
            if total<0:
                total = 0
        return maxi            
        