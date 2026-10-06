class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i-k>=0){
                if(nums[i]<=nums[i-k]){
                    continue;
                }
            }
            if(i+k<n){
                if(nums[i]<=nums[i+k]){
                    continue;
                }
            }
            sum+=nums[i];
        }
        return sum;
    }
}