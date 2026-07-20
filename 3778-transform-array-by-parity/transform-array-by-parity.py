class Solution:
    def transformArray(self, nums: List[int]) -> List[int]:
        # for i in range(len(nums)):
        #     if nums[i]%2==0:
        #         nums[i] = 0
        #     else:
        #         nums[i] = 1
        # return sorted(nums)

        return sorted([0 if nums[i]%2==0 else 1 for i in range(len(nums))])