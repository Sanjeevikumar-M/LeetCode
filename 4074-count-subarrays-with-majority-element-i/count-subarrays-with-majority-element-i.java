class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        if(Arrays.stream(nums).noneMatch(x -> x == target)){
            return 0;
        }

        int count = 0;

        for(int i=0;i<nums.length;i++){
            int targetCount = 0;

            for(int j=i;j<nums.length;j++){
                if(nums[j] == target){
                    targetCount++;
                }

                int subArrayLength = j - i + 1;

                if(targetCount*2>subArrayLength){
                    count++;
                }
            }
        }
        return count;
    }
}