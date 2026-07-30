class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] freq = new boolean[101];
        int i=nums.length-1;
        for(;i>=0;i--){
            if(freq[nums[i]]){
                return i/3+1;
            }
            freq[nums[i]] = true;;
        }
        return 0;
    }
}