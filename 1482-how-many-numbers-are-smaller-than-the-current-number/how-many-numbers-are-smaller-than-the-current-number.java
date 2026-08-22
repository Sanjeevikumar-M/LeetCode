class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int count = 0;
            for(int j:nums){
                if(j<nums[i]){
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}