class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        // for(int i=0;i<nums.length-1;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(Math.abs(nums[i]-nums[j])==k){
        //             count++;
        //         }
        //     }
        // }
        int[] bucket = new int[101];
        for(int i:nums) bucket[i]++;
        for(int i=k+1;i<101;i++) count += bucket[i]*bucket[i-k];
        return count;
    }
}