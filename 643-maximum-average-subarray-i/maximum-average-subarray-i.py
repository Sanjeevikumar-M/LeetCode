class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        curr = sum(nums[:k])
        top = curr

        for i in range(k, len(nums)):
            curr = curr + nums[i] - nums[i -k]
            if curr > top:
                top  = curr
        return top/k