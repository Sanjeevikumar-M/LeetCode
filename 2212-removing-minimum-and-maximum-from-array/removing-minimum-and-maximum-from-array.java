class Solution {
    public int minimumDeletions(int[] nums) {
        int minInd = 0, maxInd = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minInd]) minInd = i;
            if (nums[i] > nums[maxInd]) maxInd = i;
        }

        int left = Math.min(minInd, maxInd);
        int right = Math.max(minInd, maxInd);

        // 1. Both from front
        int bothFront = right + 1;
        // 2. Both from back
        int bothBack = n - left;
        // 3. One from front, one from back
        int bothEnds = (left + 1) + (n - right);

        return Math.min(bothFront, Math.min(bothBack, bothEnds));
    }
}