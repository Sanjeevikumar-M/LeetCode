class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        // dp[i][j][k] -> max coins at (i,j) using k neutralizations
        int[][][] dp = new int[m][n][3];

        // Initialize with very small values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        // Starting cell
        for (int k = 0; k < 3; k++) {
            if (coins[0][0] >= 0) {
                dp[0][0][k] = coins[0][0];
            } else {
                // either take loss or neutralize
                dp[0][0][k] = coins[0][0];
                if (k > 0) dp[0][0][k] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                for (int k = 0; k < 3; k++) {

                    int best = Integer.MIN_VALUE;

                    // from top
                    if (i > 0) {
                        best = Math.max(best, dp[i - 1][j][k]);
                    }

                    // from left
                    if (j > 0) {
                        best = Math.max(best, dp[i][j - 1][k]);
                    }

                    if (best == Integer.MIN_VALUE) continue;

                    // Case 1: take value normally
                    dp[i][j][k] = best + coins[i][j];

                    // Case 2: neutralize (only if negative and k > 0)
                    if (coins[i][j] < 0 && k > 0) {
                        int bestPrev = Integer.MIN_VALUE;

                        if (i > 0) {
                            bestPrev = Math.max(bestPrev, dp[i - 1][j][k - 1]);
                        }
                        if (j > 0) {
                            bestPrev = Math.max(bestPrev, dp[i][j - 1][k - 1]);
                        }

                        if (bestPrev != Integer.MIN_VALUE) {
                            dp[i][j][k] = Math.max(dp[i][j][k], bestPrev);
                        }
                    }
                }
            }
        }

        // Answer = max of using 0,1,2 neutralizations
        return Math.max(dp[m - 1][n - 1][0],
               Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}