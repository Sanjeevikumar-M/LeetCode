class Solution:
    def sumOfGoodNumbers(self, nums: List[int], k: int) -> int:
        n = len(nums)
        res = 0
        for i, x in enumerate(nums):
            if (i - k < 0 or x > nums[i - k]) and (i + k >= n or x > nums[i + k]):
                res += x
        return res