class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums2.length;
        int l = nums1.length;
        int[] ans = new int[l];
        for(int i=0;i<l;i++){
            int n = -1;
            int st = 0;
            for(int j=0;j<m;j++){
                if(nums2[j]==nums1[i]){
                    n = nums2[j];
                    st = j;
                    break;
                }
            }
            if(n==-1){
                ans[i] = -1;
                continue;
            }
            while(st<m){ 
                if(nums2[st]>n){
                    ans[i] = nums2[st];
                    break;
                }
                st++;
            }
            ans[i] = st==m ? -1 : nums2[st];
        }
        return ans;
    }
}