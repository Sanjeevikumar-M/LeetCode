class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int low = 1;
        int high = 400000000;
        int mid = low + (high-low)/2;
        while(low<high){
            mid = low+(high-low)/2;
            if(posible(dungeon,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
            
        }   
        return low;
    } 

    public static boolean posible(int[][] arr,int health){
        int m = arr.length;
        int n = arr[0].length;

        int[][] dp = new int[m][n];

        int startHealth = health + arr[0][0];
        if (startHealth <= 0) return false;
        dp[0][0] = startHealth;

        for (int j = 1; j < n; j++) {
            if (dp[0][j - 1] > 0) {
                int nextHealth = dp[0][j - 1] + arr[0][j];
                dp[0][j] = nextHealth > 0 ? nextHealth : 0;
            }
        }

        for (int i = 1; i < m; i++) {
            if (dp[i - 1][0] > 0) {
                int nextHealth = dp[i - 1][0] + arr[i][0];
                dp[i][0] = nextHealth > 0 ? nextHealth : 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int maxIncomingHealth = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (maxIncomingHealth > 0) {
                    int nextHealth = maxIncomingHealth + arr[i][j];
                    dp[i][j] = nextHealth > 0 ? nextHealth : 0;
                }
            }
        }
        
        return dp[m - 1][n - 1] > 0;
    }
}