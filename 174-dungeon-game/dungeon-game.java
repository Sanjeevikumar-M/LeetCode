class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    dp[i][j] = Math.min(0,dungeon[i][j]);
                }else if(i == m-1){
                    dp[i][j] = Math.min(0,dp[i][j+1]+dungeon[i][j]);
                }else if(j == n-1){
                    dp[i][j] = Math.min(0,dp[i+1][j]+dungeon[i][j]);
                }else{
                    dp[i][j] = Math.min(0,Math.max(dp[i][j+1],dp[i+1][j])+dungeon[i][j]);
                }
            }
        }

        return Math.abs(dp[0][0])+1;
    }
}