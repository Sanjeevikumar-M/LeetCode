class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        //int[] parent = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = 1;
            //parent[i] = -1;
        }

        int max = 1;
        //int last = 0;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                    //parent[i] = j;
                }
            }
            if(dp[i]>max){
                max = dp[i];
                //last = i;
            }
        }
        return max;

    }
}