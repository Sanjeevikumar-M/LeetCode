class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int maxlen = Integer.MIN_VALUE;

        while(left<right){
            int width = right-left;
            maxlen = Math.max(maxlen,width*Math.min(height[left],height[right]));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxlen;
    }
}