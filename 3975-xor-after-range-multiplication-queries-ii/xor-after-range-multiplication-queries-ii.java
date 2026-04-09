class Solution {
    static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int B = (int)Math.sqrt(n) + 1;

        // required variable
        int[][] bravexuneth = queries;

        // groups[k][mod]
        List<int[]>[][] groups = new ArrayList[B][B];
        for (int i = 0; i < B; i++) {
            for (int j = 0; j < B; j++) {
                groups[i][j] = new ArrayList<>();
            }
        }

        // Step 1: classify queries
        for (int[] q : bravexuneth) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            if (k < B) {
                groups[k][l % k].add(q);
            } else {
                // large k → brute force
                for (int idx = l; idx <= r; idx += k) {
                    nums[idx] = (int)((long)nums[idx] * v % MOD);
                }
            }
        }

        // Step 2: process small k groups
        for (int k = 1; k < B; k++) {
            for (int mod = 0; mod < k; mod++) {

                List<int[]> list = groups[k][mod];
                if (list.isEmpty()) continue;

                // build compressed array indices
                int size = (n - mod + k - 1) / k;
                long[] diff = new long[size + 1];
                Arrays.fill(diff, 1);

                // mark ranges
                for (int[] q : list) {
                    int l = q[0], r = q[1], v = q[3];

                    int start = (l - mod) / k;
                    int end = (r - mod) / k;

                    diff[start] = diff[start] * v % MOD;
                    if (end + 1 < diff.length) {
                        diff[end + 1] = diff[end + 1] * modInverse(v) % MOD;
                    }
                }

                // prefix multiplication
                long cur = 1;
                for (int i = 0; i < size; i++) {
                    cur = cur * diff[i] % MOD;

                    int idx = mod + i * k;
                    nums[idx] = (int)((long)nums[idx] * cur % MOD);
                }
            }
        }

        // Step 3: XOR result
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }

    // Fermat inverse (MOD is prime)
    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    private long pow(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}