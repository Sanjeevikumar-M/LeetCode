class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] subarrayCount = new int[51];
        int n = nums.length;

        // Iterate over every valid starting index of a subarray of size k
        for (int i = 0; i <= n - k; i++) {
            boolean[] seenInSubarray = new boolean[51];
            for (int j = i; j < i + k; j++) {
                seenInSubarray[nums[j]] = true;
            }

            // Increment the subarray count for distinct numbers present in this subarray
            for (int v = 0; v < 51; v++) {
                if (seenInSubarray[v]) {
                    subarrayCount[v]++;
                }
            }
        }

        // Find the largest integer appearing in exactly one subarray
        int max = -1;
        for (int i = 0; i < 51; i++) {
            if (subarrayCount[i] == 1) {
                max = Math.max(max, i);
            }
        }

        return max;
    }
}