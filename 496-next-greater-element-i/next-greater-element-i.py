class Solution:
    def nextGreaterElement(self, nums1: list[int], nums2: list[int]) -> list[int]:
        m = len(nums1)
        n = len(nums2)
        ans = []
        for i in range(m):
            num = -1
            st = 0
            for j in range(n):
                if nums1[i]==nums2[j]:
                    num = nums2[j]
                    st = j
                    break
            if num==-1:
                ans.append(num)
                continue
            while st<n:
                if nums2[st] > num:
                    ans.append(nums2[st])
                    break
                st+=1
            if st==n:
                ans.append(-1)
        return ans