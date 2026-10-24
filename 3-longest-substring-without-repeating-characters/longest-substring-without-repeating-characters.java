class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[128];
        for(int i=0;i<128;i++){
            hash[i] = -1;
        }
        int l = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(hash[ch]!=-1){
                if(hash[ch]>=l){
                    l = hash[ch]+1;
                }
            }
            max = Math.max(max,i-l+1);
            hash[ch] = i;
        }
        return max;
    }
}