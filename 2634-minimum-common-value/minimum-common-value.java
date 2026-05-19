class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0; // Pointer for nums1
        int j = 0; // Pointer for nums2
        
        // Traverse through both arrays until one ends
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i]; // Found the smallest common element!
            } else if (nums1[i] < nums2[j]) {
                i++; // Move nums1 pointer forward because its value is too small
            } else {
                j++; // Move nums2 pointer forward because its value is too small
            }
        }
        
        return -1; // No common element found
    }
}
