class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        num = nums1 + nums2
        num.sort()
        n = len(num)
        if n%2!=0:
            return num[n//2] + 0.00000
        else:
            m = n//2
            s = num[m] + num[m-1]
            return s/2 + 0.00000
        