class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLen = 0;
        while(left<right){
            int width = right-left;
            int h = Math.min(height[left],height[right]);
            maxLen = Math.max(maxLen,width*h);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxLen;
    }
}