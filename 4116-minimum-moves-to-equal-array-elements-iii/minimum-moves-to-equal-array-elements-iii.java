class Solution {
    public int minMoves(int[] nums) {
        int m = nums[0];
        int sum = 0;
        for(int i:nums){
            if(i>m) m = i;
            sum+=i;
        }
        return m*nums.length-sum;
    }
}