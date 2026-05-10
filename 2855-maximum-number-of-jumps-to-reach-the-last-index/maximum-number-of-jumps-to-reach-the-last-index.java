class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;

        // dp[i] = maximum jumps needed to reach index i
        int[] dp = new int[n];

        // initialize with -1 (unreachable)
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {

                long diff = (long) nums[j] - nums[i];

                if (diff >= -target && diff <= target && dp[i] != -1) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}