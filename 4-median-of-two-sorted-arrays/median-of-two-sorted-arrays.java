class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] sortedArray = new int[n+m];
        for(int i=0;i<m;i++){
            sortedArray[i] = nums1[i];
        }
        for(int i=m,j=0;i<n+m;i++,j++){
            sortedArray[i] = nums2[j];
        }
        Arrays.sort(sortedArray);
        int l = sortedArray.length;
        if(l%2!=0){
            return (double) sortedArray[l/2];
        }else{
            return (double) (sortedArray[l/2]+sortedArray[l/2-1])/2;
        }
    }
}