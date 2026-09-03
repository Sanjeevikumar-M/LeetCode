class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = nums1[0], odd=0;

        for(int i:nums1){
            min = Math.min(min,i);
            odd |= i&1;
        }

        return (min&1) == odd;
    }
}