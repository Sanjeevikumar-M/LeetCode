class Solution {
    public int countPartitions(int[] nums) {
        int totalsum = 0;
        for(int i:nums){
            totalsum+=i;
        }

        int count = 0;
        int leftsum = 0;
        for(int i=0;i<nums.length-1;i++){
            leftsum+=nums[i];
            int rightsum=totalsum-leftsum;
            if(leftsum%2 == rightsum%2){
                count++;
            }
        }
        return count;
    }
}