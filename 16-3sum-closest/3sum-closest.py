class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        n = len(nums)
        closestSum = nums[0]+nums[1]+nums[2]
        for i in range(n-2):
            if i>0 and nums[i]==nums[i-1]:
                continue
            left = i+1
            right = n-1
            while left<right:
                s = nums[i]+nums[left]+nums[right]
                if s==target:
                    return s
                if abs(s-target)<abs(closestSum-target):
                    closestSum = s
                if s<target:
                    left+=1
                else:
                    right-=1
        return closestSum