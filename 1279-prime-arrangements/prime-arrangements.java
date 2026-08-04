class Solution {
     private static final int MOD = 1_000_000_007;
    public int numPrimeArrangements(int n) {
         int primes = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes++;
            }
        }

        int nonPrimes = n - primes;
        long ans = 1;

        for (int i = 2; i <= primes; i++) {
            ans = ans * i % MOD;
        }

        for (int i = 2; i <= nonPrimes; i++) {
            ans = ans * i % MOD;
        }

        return (int) ans;
    }

    private boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}