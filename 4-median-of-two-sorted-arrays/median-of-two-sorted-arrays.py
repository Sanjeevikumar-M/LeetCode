class Solution:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        nums = nums1+nums2
        nums.sort()
        l = len(nums)
        if l%2!=0:
            return float(nums[l//2])
        else:
            return float((nums[l//2]+nums[l//2-1])/2)