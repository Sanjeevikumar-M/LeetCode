class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int i=nums.length-1;
        for(;i>=0;i--){
            if(set.contains(nums[i])){
                break;
            }
            set.add(nums[i]);
        }
        return (i+3)/3;
    }
}