import java.util.*;

class Solution {
    public int[] closestPrimes(int left, int right) {
        // Step 1: Sieve of Eratosthenes to find primes up to 'right'
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p <= right; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= right; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Step 2: Collect primes in range [left, right]
        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // Less than 2 primes means no pair exists
        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        // Step 3: Find adjacent pair with minimum difference
        int minDiff = Integer.MAX_VALUE;
        int num1 = -1, num2 = -1;

        for (int i = 1; i < primes.size(); i++) {
            int p1 = primes.get(i - 1);
            int p2 = primes.get(i);
            int diff = p2 - p1;

            if (diff < minDiff) {
                minDiff = diff;
                num1 = p1;
                num2 = p2;
            }

            // Early exit: 2 is the minimum possible gap for primes > 2
            if (minDiff <= 2) {
                return new int[]{num1, num2};
            }
        }

        return new int[]{num1, num2};
    }
}