class Solution:
    def missingNumber(self, nums: list[int]) -> int:
        s = sum(nums)
        n = len(nums)
        acs = n*(n+1)//2
        return acs-s