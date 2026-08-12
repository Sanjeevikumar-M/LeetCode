class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = 0;
        for(int i=0;i<k;i++){
            max+=nums[i];
        }
        double currSum = max;
        for(int i=k;i<nums.length;i++){
            currSum+=nums[i]-nums[i-k];
            if(max<currSum){
                max = currSum;
            }
        }
        return (double) max/k;
    }
}