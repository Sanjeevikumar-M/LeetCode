class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n*2];
        System.arraycopy(nums,0,ans,0,n);
        for(int i=n;i<ans.length;i++){
            ans[i] = nums[2*n-1-i];
        }
        return ans;
    }
}