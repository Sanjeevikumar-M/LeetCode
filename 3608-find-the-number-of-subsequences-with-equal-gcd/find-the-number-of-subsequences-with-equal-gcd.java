class Solution {
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int maxVal = 200;
        int MOD = 1_000_000_007;

        // dp[g1][g2] stores the number of valid pairs with current GCDs g1 and g2
        int[][] dp = new int[maxVal + 1][maxVal + 1];
        
        // Base case: 1 way to have both subsequences empty (GCD represented as 0)
        dp[0][0] = 1;

        for (int x : nums) {
            int[][] nextDp = new int[maxVal + 1][maxVal + 1];
            
            for (int g1 = 0; g1 <= maxVal; g1++) {
                for (int g2 = 0; g2 <= maxVal; g2++) {
                    if (dp[g1][g2] == 0) continue;

                    long count = dp[g1][g2];

                    // Option 1: Skip the current element x
                    nextDp[g1][g2] = (int) ((nextDp[g1][g2] + count) % MOD);

                    // Option 2: Add x to the first subsequence
                    int ng1 = (g1 == 0) ? x : gcd(g1, x);
                    nextDp[ng1][g2] = (int) ((nextDp[ng1][g2] + count) % MOD);

                    // Option 3: Add x to the second subsequence
                    int ng2 = (g2 == 0) ? x : gcd(g2, x);
                    nextDp[g1][ng2] = (int) ((nextDp[g1][ng2] + count) % MOD);
                }
            }
            dp = nextDp;
        }

        // Gather results where g1 == g2 and both are non-empty (i.e., > 0)
        long totalPairs = 0;
        for (int g = 1; g <= maxVal; g++) {
            totalPairs = (totalPairs + dp[g][g]) % MOD;
        }

        return (int) totalPairs;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}