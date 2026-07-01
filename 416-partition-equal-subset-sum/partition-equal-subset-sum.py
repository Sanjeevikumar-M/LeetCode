class Solution:
    def canPartition(self, nums: list[int]) -> bool:
        n = sum(nums)
        if n%2!=0:
            return False
        ss = n//2
        dp = [False]*(ss+1)
        dp[0] = True
        for num in nums:
            for i in range(ss,num-1,-1):
                dp[i] = dp[i] or dp[i-num]
        return dp[ss]
