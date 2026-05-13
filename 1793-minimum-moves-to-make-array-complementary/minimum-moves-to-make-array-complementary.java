class Solution {
    public int minMoves(int[] nums, int limit) {

        int n = nums.length;

        // Difference array
        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {

            int a = nums[i];
            int b = nums[n - 1 - i];

            int min = Math.min(a, b);
            int max = Math.max(a, b);
            int sum = a + b;

            /*
                Initially every target needs 2 moves.

                Then reduce moves for ranges:
                
                [min+1, max+limit] -> 1 move
                [sum]              -> 0 move
            */

            // Start with 2 moves for all sums
            diff[2] += 2;

            // 1 move range starts
            diff[min + 1] -= 1;

            // 0 move at exact sum
            diff[sum] -= 1;

            // Back to 1 move after sum
            diff[sum + 1] += 1;

            // Back to 2 moves after range ends
            diff[max + limit + 1] += 1;
        }

        int ans = Integer.MAX_VALUE;
        int curr = 0;

        for (int s = 2; s <= 2 * limit; s++) {
            curr += diff[s];
            ans = Math.min(ans, curr);
        }

        return ans;
    }
}