class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int curr = 0;
        while(curr<=right){
            if(nums[curr]==0){
                swap(nums,curr,left);
                curr++;
                left++;
            }
            else if(nums[curr]==1){
                curr++;
            }
            else if(nums[curr]==2){
                swap(nums,curr,right);
                right--;
            }
            else{
                swap(nums,curr,right);
                right--;
            }
        }
    }
    static void swap(int[] nums,int i,int j){
        int curr = nums[i];
        nums[i] = nums[j];
        nums[j] = curr;
    }
}