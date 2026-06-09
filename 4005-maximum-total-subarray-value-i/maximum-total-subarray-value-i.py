class Solution:
    def maxTotalValue(self, nums: List[int], k: int) -> int:
        sum=0
        ma = max(nums)
        mi = min(nums)
        diff = ma - mi
        sum = diff*k
        return sum