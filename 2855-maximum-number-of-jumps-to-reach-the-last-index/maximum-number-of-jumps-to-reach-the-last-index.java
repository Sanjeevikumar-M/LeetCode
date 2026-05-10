class Solution {
    public int maximumJumps(int[] nums, int target) {
        if(nums.length==2){
            int dif = nums[1]-nums[0];
                if((-1*target)<=dif && dif<=target){
                    return 1;
                }
                else{
                    return -1;
                }
        }
        int dp[]= new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0]=0;
        for(int i=0;i<nums.length-1;i++){
            if(dp[i]==Integer.MIN_VALUE) continue;
            for(int j=i+1;j<nums.length;j++){
                int dif = nums[j]-nums[i];
                if((-1*target)<=dif && dif<=target){
                    dp[j]=Math.max(1+dp[i],dp[j]);
                }
            }
        }
        return dp[nums.length-1]==Integer.MIN_VALUE?-1:dp[nums.length-1];
    }
}