class Solution {

    public int numberOfStableArrays(int zero, int one, int limit) {

        final int mod = 1_000_000_007;
        int L = limit + 1;

        // dp0[i][j] = arrays with i zeros and j ones ending with 0
        int[][] dp0 = new int[zero + 1][one + 1];

        // dp1[i][j] = arrays with i zeros and j ones ending with 1
        int[][] dp1 = new int[zero + 1][one + 1];

        // Base cases: only zeros
        for (int i = 1; i <= Math.min(zero, limit); ++i) {
            dp0[i][0] = 1;
        }

        // Base cases: only ones
        for (int j = 1; j <= Math.min(one, limit); ++j) {
            dp1[0][j] = 1;
        }

        // DP iterations
        for (int i = 1; i <= zero; ++i) {
            for (int j = 1; j <= one; ++j) {

                dp0[i][j] =
                        (dp0[i - 1][j]
                        + dp1[i - 1][j]
                        - (i >= L ? dp1[i - L][j] : 0)) % mod;

                dp1[i][j] =
                        (dp1[i][j - 1]
                        + dp0[i][j - 1]
                        - (j >= L ? dp0[i][j - L] : 0)) % mod;

                // Fix negative values
                dp0[i][j] = (dp0[i][j] + mod) % mod;
                dp1[i][j] = (dp1[i][j] + mod) % mod;
            }
        }

        return (dp0[zero][one] + dp1[zero][one]) % mod;
    }
}