class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        int[] arr = {26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i) - 'a';
            sum+= (arr[ch]*(i+1));
        }
        return sum;
    }
}