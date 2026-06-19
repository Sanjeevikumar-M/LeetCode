class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i=1;i<n+1;i++){
            dp[i] = dp[i-1]+gain[i-1];
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n+1;i++){
            if(max<dp[i]){
                max = dp[i];
            }
        }
        return max;
    }
}