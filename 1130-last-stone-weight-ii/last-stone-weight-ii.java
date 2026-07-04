class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for(int stone:stones){
            totalSum+=stone;
        }
        
        int s1 = totalSum/2;
        boolean[] dp = new boolean[s1+1];
        dp[0] = true;
        for(int stone:stones){
            for(int i = s1;i>=stone;i--){
                if(dp[i-stone]){
                    dp[i] = true;
                }
            }
        }

        for(int i=s1;i>=0;i--){
            if(dp[i]){
                return totalSum-2*i;
            }
        }
        return 0;
    }
}