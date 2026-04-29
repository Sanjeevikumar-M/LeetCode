class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        long[][] cp = new long[n][n + 1];
        for (int j = 0; j < n; j++)
            for (int i = 0; i < n; i++)
                cp[j][i + 1] = cp[j][i] + grid[i][j];

        final long NEG = Long.MIN_VALUE / 2;
        // dp[hp][hc] = best score, col j-1 height=hp, col j height=hc, col j score pending
        long[][] dp = new long[n + 1][n + 1];
        for (long[] r : dp) java.util.Arrays.fill(r, NEG);
        for (int h0 = 0; h0 <= n; h0++) dp[0][h0] = 0; // dummy h_prev=0 for col 0

        for (int j = 0; j < n - 1; j++) {
            long[][] ndp = new long[n + 1][n + 1];
            for (long[] r : ndp) java.util.Arrays.fill(r, NEG);

            for (int hc = 0; hc <= n; hc++) {
                // score(col j) = max(0, cp[j][max(hp,hn)] - cp[j][hc])
                // Case 1: hp >= hn → score uses hp (independent of hn)
                //   A[hp] = dp[hp][hc] + (hp > hc ? cp[j][hp] - cp[j][hc] : 0)
                // Case 2: hp < hn  → score uses hn (independent of hp)
                //   need prefMax of dp[hp][hc] for hp in [0, hn-1]

                // Precompute suffix max of A[hp] for Case 1
                long[] suffMax = new long[n + 2];
                suffMax[n + 1] = NEG;
                for (int hp = n; hp >= 0; hp--) {
                    long a = dp[hp][hc];
                    if (a != NEG) a += (hp > hc ? cp[j][hp] - cp[j][hc] : 0);
                    suffMax[hp] = Math.max(a, suffMax[hp + 1]);
                }

                long prefMax = NEG; // max dp[hp][hc] for hp < hn
                for (int hn = 0; hn <= n; hn++) {
                    // Case 1: hp >= hn
                    if (suffMax[hn] != NEG)
                        ndp[hc][hn] = Math.max(ndp[hc][hn], suffMax[hn]);
                    // Case 2: hp < hn
                    if (prefMax != NEG) {
                        long add = hn > hc ? cp[j][hn] - cp[j][hc] : 0;
                        ndp[hc][hn] = Math.max(ndp[hc][hn], prefMax + add);
                    }
                    if (dp[hn][hc] != NEG)
                        prefMax = Math.max(prefMax, dp[hn][hc]);
                }
            }
            dp = ndp;
        }

        // Finalize last column (no right neighbor)
        long ans = 0;
        for (int hp = 0; hp <= n; hp++)
            for (int hc = 0; hc <= n; hc++) {
                if (dp[hp][hc] == NEG) continue;
                long score = hp > hc ? cp[n - 1][hp] - cp[n - 1][hc] : 0;
                ans = Math.max(ans, dp[hp][hc] + score);
            }
        return ans;
    }
}