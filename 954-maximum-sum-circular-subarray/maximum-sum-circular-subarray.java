class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int cursum1 = 0;
        int cursum2 = 0;
        int totalSum = 0;
        int res1 = nums[0];
        int res2 = nums[0];
        for(int i:nums){
            totalSum += i;
            if(cursum1<0) cursum1=0;
            cursum1+=i;
            res1 = Math.max(res1,cursum1);
        }
        for(int i:nums){
            if(cursum2>0) cursum2=0;
            cursum2+=i;
            res2 = Math.min(res2,cursum2);
        }
        if(totalSum==res2) return res1;
        return Math.max(res1,totalSum-res2);
    }
}