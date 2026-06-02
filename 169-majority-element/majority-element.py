class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        n = len(nums)
        counts = {}

        for x in nums:
            counts[x] = counts.get(x,0)+1

        for key in counts:
            if counts.get(key) > n//2:
                return key

        return -1
        