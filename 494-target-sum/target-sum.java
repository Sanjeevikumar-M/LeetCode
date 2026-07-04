class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int num:nums){
            totalSum += num;
        }
        if(totalSum+target < 0 || (totalSum+target)%2 !=0){
            return 0;
        }
        int s1 = (target+totalSum)/2;
        int[] dp = new int[s1+1];
        dp[0] = 1;
        for(int num:nums){
            for(int i=s1;i>num-1;i--){
                dp[i] += dp[i-num];
            }
        }
        return dp[s1];
    }
}