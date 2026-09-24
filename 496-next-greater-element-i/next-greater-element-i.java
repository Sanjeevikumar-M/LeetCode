class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int l = nums2.length;
        int[] ans = new int[m];
        for(int i=0;i<m;i++){
            int n = -1;
            int st = 0;
            for(int j=0;j<l;j++){
                if(nums2[j]==nums1[i]){
                    n = nums2[j];
                    st = j;
                    break;
                }
            }
            if(n==-1){
                ans[i] = n;
                continue;
            }
            while(st<l){
                if(nums2[st]>n){
                    ans[i]=nums2[st];
                    break;
                }
                st++;
            }
            if(st==l){
                ans[i] = -1;
            }
        }
        return ans;
    }
}