class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int avg = nums[nums.length/2];
        int res = 0;
        for(int i:nums){
            res+=Math.abs(avg-i);
        }
        return res;
    }
}