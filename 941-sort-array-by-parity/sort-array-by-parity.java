class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        int k=0,j=nums.length - 1;
        for(int i:nums){
            if(i%2==0){
                ans[k]=i;
                k++;
            }else{
                ans[j] = i;
                j--;
            }
        }
        return ans;
    }
}