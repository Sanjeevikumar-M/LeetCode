class Solution:
    def minMoves(self, nums: list[int]) -> int:
        m = min(nums)
        s = sum(nums)
        return s - (m*len(nums))