class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] freq = new boolean[101];
        int i=nums.length-1;
        for(;i>=0;i--){
            if(freq[nums[i]]){
                break;
            }
            freq[nums[i]] = true;;
        }
        return (i+3)/3;
    }
}