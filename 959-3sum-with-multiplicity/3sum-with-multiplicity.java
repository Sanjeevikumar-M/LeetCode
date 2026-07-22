class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long[] count = new long[101];
        for (int x : arr) {
            count[x]++;
        }
        
        long ans = 0;
        long MOD = 1_000_000_007;

        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k < j || k > 100) continue;
                
                if (count[i] == 0 || count[j] == 0 || count[k] == 0) continue;

                if (i == j && j == k) {
                    ans += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                } else if (i == j && j != k) {
                    ans += count[i] * (count[i] - 1) / 2 * count[k];
                } else if (i != j && j == k) {
                    ans += count[i] * count[j] * (count[j] - 1) / 2;
                } else { // i < j < k
                    ans += count[i] * count[j] * count[k];
                }

                ans %= MOD;
            }
        }

        return (int) ans;
    }
}