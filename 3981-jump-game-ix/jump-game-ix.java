import java.util.*;

class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        int[] ans = new int[n];

        int start = 0;
        int componentMax = nums[0];

        for (int i = 0; i < n - 1; i++) {
            componentMax = Math.max(componentMax, nums[i]);

            // Cut between i and i+1
            // No inversion crosses this boundary
            if (prefixMax[i] <= suffixMin[i + 1]) {

                for (int j = start; j <= i; j++) {
                    ans[j] = componentMax;
                }

                start = i + 1;

                if (start < n) {
                    componentMax = nums[start];
                }
            }
        }

        // Last component
        componentMax = nums[start];
        for (int i = start; i < n; i++) {
            componentMax = Math.max(componentMax, nums[i]);
        }

        for (int i = start; i < n; i++) {
            ans[i] = componentMax;
        }

        return ans;
    }
}