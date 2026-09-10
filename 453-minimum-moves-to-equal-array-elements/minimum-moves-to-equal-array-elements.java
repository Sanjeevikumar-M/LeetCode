class Solution {
    public int minMoves(int[] nums) {
        // int n = nums.length;
        // int count = 0;
        // int sum = 0;
        // int min = Integer.MAX_VALUE;

        // for(int i:nums){
        //     sum+=i;
        //     min = i<min ? i : min;
        // }

        // int leftside = n*(min+count);
        // int rightside = sum+count*(n-1);
        // while(leftside!=rightside){
        //     count++;
        //     leftside = n*(min+count);
        //     rightside = sum+count*(n-1);
        // }
        // return count;

        if(nums==null || nums.length<=1) return 0;
        long min = (long) nums[0];
        long sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=(long) nums[i];
            min = Math.min(min,nums[i]);
        }
        return (int) (sum-min*nums.length);
    }
}