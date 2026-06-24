import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;

    // Helper to multiply two square matrices
    private long[][] multiply(long[][] A, long[][] B) {
        int sz = A.length;
        long[][] C = new long[sz][sz];
        for (int i = 0; i < sz; i++) {
            for (int k = 0; k < sz; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < sz; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    // Helper to compute (base^exp) using binary exponentiation
    private long[][] power(long[][] base, long exp) {
        int sz = base.length;
        long[][] result = new long[sz][sz];
        for (int i = 0; i < sz; i++) {
            result[i][i] = 1; // Identity matrix
        }
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiply(result, base);
            }
            base = multiply(base, base);
            exp >>= 1;
        }
        return result;
    }

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int states = 2 * m;

        // Lambda-like mapping helper: 
        // dir = 0 (DOWN), dir = 1 (UP)
        // state index = dir * m + val
        long[][] T = new long[states][states];

        // Populate transition matrix
        for (int x = 0; x < m; x++) {
            // From (x, UP) we must go DOWN to some y < x
            for (int y = 0; y < x; y++) {
                int fromState = 1 * m + x; // UP
                int toState = 0 * m + y;   // DOWN
                T[toState][fromState]++;
            }
            // From (x, DOWN) we must go UP to some y > x
            for (int y = x + 1; y < m; y++) {
                int fromState = 0 * m + x; // DOWN
                int toState = 1 * m + y;   // UP
                T[toState][fromState]++;
            }
        }

        // Base case counts for arrays of length 2
        long[] start = new long[states];
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < m; b++) {
                if (a == b) continue;
                if (a < b) {
                    start[1 * m + b]++; // Ended on an UP step
                } else {
                    start[0 * m + b]++; // Ended on a DOWN step
                }
            }
        }

        // Compute T^(n - 2)
        long[][] P = power(T, n - 2);

        // Multiply P by the start vector to get final counts
        long ans = 0;
        for (int i = 0; i < states; i++) {
            long currentStateCount = 0;
            for (int j = 0; j < states; j++) {
                currentStateCount = (currentStateCount + P[i][j] * start[j]) % MOD;
            }
            ans = (ans + currentStateCount) % MOD;
        }

        return (int) ans;
    }
}