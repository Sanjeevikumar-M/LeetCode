class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m];
        for(int i=0;i<m;i++){
            int num = -1;
            int st = 0;
            for(int j=0;j<n;j++){
                if(nums2[j]==nums1[i]){
                    num = nums2[j];
                    st = j;
                    break;
                }
            }
            if(num==-1){
                ans[i] = num;
                continue;
            }
            while(st<n){
                if(nums2[st]>num){
                    ans[i] = nums2[st];
                    break;
                }
                st++;
            }
            if(st==n){
                ans[i] = -1;
            }
        }
        return ans;
    }
}