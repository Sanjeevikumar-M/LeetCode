class Solution {

    int MOD = 1_000_000_007;
    int[][][][] memo;

    public int numberOfStableArrays(int zero, int one, int limit) {
        memo = new int[zero + 1][one + 1][2][limit + 1];

        for (int z = 0; z <= zero; z++)
            for (int o = 0; o <= one; o++)
                for (int l = 0; l < 2; l++)
                    for (int c = 0; c <= limit; c++)
                        memo[z][o][l][c] = -1;

        long ans = 0;

        if (zero > 0)
            ans = (ans + dfs(zero - 1, one, 0, 1, limit)) % MOD;

        if (one > 0)
            ans = (ans + dfs(zero, one - 1, 1, 1, limit)) % MOD;

        return (int) ans;
    }

    int dfs(int z, int o, int last, int count, int limit) {

        if (z == 0 && o == 0)
            return 1;

        if (memo[z][o][last][count] != -1)
            return memo[z][o][last][count];

        long res = 0;

        // place 0
        if (z > 0) {
            if (last == 0) {
                if (count < limit)
                    res += dfs(z - 1, o, 0, count + 1, limit);
            } else {
                res += dfs(z - 1, o, 0, 1, limit);
            }
        }

        // place 1
        if (o > 0) {
            if (last == 1) {
                if (count < limit)
                    res += dfs(z, o - 1, 1, count + 1, limit);
            } else {
                res += dfs(z, o - 1, 1, 1, limit);
            }
        }

        return memo[z][o][last][count] = (int)(res % MOD);
    }
}