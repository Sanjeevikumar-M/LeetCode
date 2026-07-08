class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        long MOD = 1_000_000_007;
        int m = s.length();

        long[] pow10 = new long[m + 1];
        long[] prefixVal = new long[m + 1];
        int[] prefixSum = new int[m + 1];
        int[] nonZeroCount = new int[m + 1];

        pow10[0] = 1;
        for (int i = 0; i < m; i++) {
            int digit = s.charAt(i) - '0';
            pow10[i + 1] = (pow10[i] * 10) % MOD;
            prefixSum[i + 1] = prefixSum[i] + digit;
            
            if (digit != 0) {
                prefixVal[i + 1] = (prefixVal[i] * 10 + digit) % MOD;
                nonZeroCount[i + 1] = nonZeroCount[i] + 1;
            } else {
                prefixVal[i + 1] = prefixVal[i];
                nonZeroCount[i + 1] = nonZeroCount[i];
            }
        }

        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0], r = queries[q][1];
            
            long totalSum = prefixSum[r + 1] - prefixSum[l];
            int powerShift = nonZeroCount[r + 1] - nonZeroCount[l];
            
            long x = (prefixVal[r + 1] - (prefixVal[l] * pow10[powerShift]) % MOD + MOD) % MOD;

            ans[q] = (int) ((x * totalSum) % MOD);
        }

        return ans;   
    }
}