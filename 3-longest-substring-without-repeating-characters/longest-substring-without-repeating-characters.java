class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[128];
        int l = 0;
        int max = 0;
        for(int i=0;i<128;i++){
            hash[i] = -1;
        }
        for(int r = 0;r<s.length();r++){
            char ch = s.charAt(r);
            if(hash[ch]!=-1){
                if(hash[ch]>=l){
                    l = hash[ch]+1;
                }
            }
            max = Math.max(max,r-l+1);
            hash[ch] = r;
        }
        return max;
    }
}