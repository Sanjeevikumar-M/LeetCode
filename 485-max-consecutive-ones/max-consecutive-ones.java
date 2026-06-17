class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int x = 0;
        int m = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=1){
                m = Math.max(m,x);
                x = 0;
            }else{
                x++;
            }
        }
        m = Math.max(m,x);
        return m;
    }
}