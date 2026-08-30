class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int pre = 1;
            for(int j=i;j<n;j++){
                pre *= nums[j];
                ans = Math.max(ans,pre);
            }
        }
        return ans;
    }
}