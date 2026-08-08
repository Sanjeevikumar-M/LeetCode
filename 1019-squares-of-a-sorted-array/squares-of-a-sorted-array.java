class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int left=0, right=n-1, index=n-1;

        while(left<=right){
            int leftSum=nums[left]*nums[left];
            int rightSum= nums[right]*nums[right];

            if(leftSum>rightSum){
                ans[index]=leftSum;
                left++;
            }else{
                ans[index]=rightSum;
                right--;
            }
            index--;
        }
        return ans;
        
    }
}