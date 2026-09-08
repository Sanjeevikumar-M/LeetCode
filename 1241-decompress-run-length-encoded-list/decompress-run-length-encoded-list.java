class Solution {
    public int[] decompressRLElist(int[] nums) {
        int size = 0;
        for(int i = 0; i < nums.length; i += 2) {
            size += nums[i];
        }
        int[] ans = new int[size];
        int index = 0;
        for(int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int value = nums[i + 1];
            for(int j = 0; j < freq; j++) {
                ans[index] = value;
                index++;
            }
        }
        return ans;
    }
}