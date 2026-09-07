class Solution {
    public int countPartitions(int[] nums) {
        int prev = 0;
        int sum = 0;
        int result = 0;

        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            prev += nums[i];

            if ((prev - (sum - prev)) % 2 == 0) {
                result++;
            }
        }

        return result;
    }
}