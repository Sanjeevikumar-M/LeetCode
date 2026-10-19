class Solution:
    def targetIndices(self, nums: list[int], target: int) -> list[int]:
        l = []
        nums.sort()
        for i,n in enumerate(nums):
            if n == target:
                l.append(i)
        return l