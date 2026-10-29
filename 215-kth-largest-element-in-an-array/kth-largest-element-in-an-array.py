class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        nums = sorted(nums)
        nums = nums[::-1]
        return nums[k-1]