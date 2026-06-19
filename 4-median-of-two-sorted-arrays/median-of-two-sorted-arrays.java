class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] sorted_array = new int[n+m];
        for(int i=0;i<n;i++){
            sorted_array[i] = nums1[i];
        }
        int j = 0;
        for(int i=n;i<m+n;i++){
            sorted_array[i] = nums2[j];
            j++;
        }
        Arrays.sort(sorted_array);
        int l = sorted_array.length;
        if(l%2!=0){
            return (float) sorted_array[l/2];
        }else{
            int mid = l/2;
            int s = sorted_array[mid]+sorted_array[mid-1];
            return (float) s/2;
        }
    }
}