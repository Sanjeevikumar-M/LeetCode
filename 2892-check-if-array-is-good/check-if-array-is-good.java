class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // Length must be max + 1
        if (max != n - 1) {
            return false;
        }

        int[] freq = new int[max + 1];

        for (int x : nums) {
            if (x > max) {
                return false;
            }
            freq[x]++;
        }

        // 1 to max-1 should appear once
        for (int i = 1; i < max; i++) {
            if (freq[i] != 1) {
                return false;
            }
        }

        // max should appear twice
        return freq[max] == 2;
    }
}