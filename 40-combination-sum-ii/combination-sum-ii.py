class Solution:
    def combinationSum2(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        nums.sort()
        def dfs(i,comb,total):
            if total == target:
                res.append(comb.copy())
                return 
            
            for j in range(i,len(nums)):
                if total + nums[j] > target: break

                if j>i and nums[j] == nums[j-1]: continue

                comb.append(nums[j])
                dfs(j+1,comb,total+nums[j])
                comb.pop()
        dfs(0,[],0)
        return res