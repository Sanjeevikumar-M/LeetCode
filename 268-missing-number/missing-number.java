class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int s1 = n*(n+1)/2;
        int s2 = 0;
        for(int i:nums){
            s2+=i;
        }
        return s1-s2;
    }
}