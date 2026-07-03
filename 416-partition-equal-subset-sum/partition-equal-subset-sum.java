class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum += num; 
        }
        if(sum%2!=0){
            return false;
        }
        int ss = sum/2;
        boolean[] dp = new boolean[ss+1];
        dp[0] = true;
        for(int num:nums){
            for(int i=ss;i>num-1;i--){
                dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[ss];
    }
}