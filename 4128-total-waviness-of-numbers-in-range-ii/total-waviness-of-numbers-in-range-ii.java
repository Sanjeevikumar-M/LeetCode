import java.util.Arrays;

class Solution {
    // DP cache table: [idx][prev][trend][tight][started]
    // Max digits for a 64-bit long is around 19.
    private Long[][][][][] dp;

    public long totalWaviness(long num1, long num2) {
        return solve(Long.toString(num2)) - solve(Long.toString(num1 - 1));
    }

    private long solve(String s) {
        if (s.equals("-1") || s.equals("0")) return 0;
        
        int n = s.length();
        // Resetting the DP table for this upper bound string
        dp = new Long[n][10][3][2][2];
        
        return countWaviness(0, 0, 0, 1, 0, s);
    }

    private long countWaviness(int idx, int prev, int trend, int tight, int started, String s) {
        if (idx == s.length()) {
            return 0; // Reached the end of the number
        }

        if (dp[idx][prev][trend][tight][started] != null) {
            return dp[idx][prev][trend][tight][started];
        }

        long ans = 0;
        int limit = (tight == 1) ? (s.charAt(idx) - '0') : 9;

        for (int digit = 0; digit <= limit; digit++) {
            int nextTight = (tight == 1 && digit == limit) ? 1 : 0;
            
            if (started == 0) {
                // If we haven't started forming a valid number yet
                if (digit == 0) {
                    // Continuing leading zeros
                    ans += countWaviness(idx + 1, 0, 0, nextTight, 0, s);
                } else {
                    // First valid digit placed
                    ans += countWaviness(idx + 1, digit, 0, nextTight, 1, s);
                }
            } else {
                // We have already started forming the number
                int nextTrend = 0;
                long contribution = 0;

                if (trend == 0) {
                    // This is the second digit being placed
                    if (digit > prev) nextTrend = 1;      // Upward direction
                    else if (digit < prev) nextTrend = 2; // Downward direction
                    else nextTrend = 0;                  // Flat (cannot form waves)
                } else if (trend == 1) {
                    // Previous movement was increasing (Upward)
                    if (digit < prev) {
                        // Current digit turns it into a Peak!
                        contribution = 1;
                        nextTrend = 2;
                    } else if (digit > prev) {
                        nextTrend = 1; // Kept going up
                    } else {
                        nextTrend = 0; // Flat line kills the waviness potential
                    }
                } else if (trend == 2) {
                    // Previous movement was decreasing (Downward)
                    if (digit > prev) {
                        // Current digit turns it into a Valley!
                        contribution = 1;
                        nextTrend = 1;
                    } else if (digit < prev) {
                        nextTrend = 2; // Kept going down
                    } else {
                        nextTrend = 0; // Flat line
                    }
                }

                // If a peak or valley was detected at 'prev', it contributes to all valid suffixes 
                // that can be formed from this point forward.
                if (contribution == 1) {
                    ans += countValidSuffixes(idx + 1, nextTight, s);
                }

                // Carry forward the recursive search to find more peaks/valleys further down the line
                ans += countWaviness(idx + 1, digit, nextTrend, nextTight, 1, s);
            }
        }

        return dp[idx][prev][trend][tight][started] = ans;
    }

    // Helper to calculate how many total combinations are possible down a certain path
    private long countValidSuffixes(int idx, int tight, String s) {
        if (idx == s.length()) return 1;
        if (tight == 0) {
            return (long) Math.pow(10, s.length() - idx);
        }
        
        long count = 0;
        int limit = s.charAt(idx) - '0';
        for (int digit = 0; digit <= limit; digit++) {
            int nextTight = (digit == limit) ? 1 : 0;
            count += countValidSuffixes(idx + 1, nextTight, s);
        }
        return count;
    }
}