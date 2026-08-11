class Solution {
    public int missingInteger(int[] nums) {
        int sum = 0;
        int i=1;
        for(;i<nums.length;i++){
            sum+=nums[i-1];
            if(nums[i]!=nums[i-1]+1){
                break;
            }   
        }
        System.out.println(i);
        if(i == nums.length){
            sum+=nums[i-1];
        }
        int[] arr = new int[51];
        for(int j:nums){
            arr[j]++;
        }
        while(sum<arr.length){
            if(arr[sum]==0){
                return sum;
            }
            sum++;
        }
        return sum;
    }
}