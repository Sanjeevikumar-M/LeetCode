class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(sum, max);
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
        // int n = nums.length;
        // if(n == 1) return nums[0];
        // int curr = nums[0];
        // int max = nums[0];
        // for(int i=1;i<n;i++){
        //     curr = Math.max(nums[i],curr+nums[i]);
        //     max = Math.max(max,curr);
        // }
        // return max;
    }
}