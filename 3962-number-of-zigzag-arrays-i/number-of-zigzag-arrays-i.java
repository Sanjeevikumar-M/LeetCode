class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        // Length = 2 initialization
        for (int b = 0; b < m; b++) {
            up[b] = b;                 // values smaller than b
            down[b] = m - 1 - b;      // values greater than b
        }

        if (n == 2) {
            long ans = 0;
            for (int i = 0; i < m; i++) {
                ans = (ans + up[i] + down[i]) % MOD;
            }
            return (int) ans;
        }

        for (int len = 3; len <= n; len++) {

            long[] prefDown = new long[m];
            long[] prefUp = new long[m];

            prefDown[0] = down[0];
            prefUp[0] = up[0];

            for (int i = 1; i < m; i++) {
                prefDown[i] = (prefDown[i - 1] + down[i]) % MOD;
                prefUp[i] = (prefUp[i - 1] + up[i]) % MOD;
            }

            long totalUp = prefUp[m - 1];

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for (int y = 0; y < m; y++) {

                // sum down[x] where x < y
                if (y > 0)
                    newUp[y] = prefDown[y - 1];

                // sum up[x] where x > y
                long left = prefUp[y];
                newDown[y] = (totalUp - left + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}