class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[255];
        Arrays.fill(hash,-1);
        int n = s.length();
        int l = 0;
        int r = 0;
        int max = 0;
        while(r<n){
            char ch = s.charAt(r);
            if(hash[ch]!=-1){
                if(hash[ch]>=l){
                    l = hash[ch] + 1;
                }
            }
            int len = r-l+1;
            max = Math.max(max,len);
            hash[ch] = r;
            r++;
        }
        return max;
    }
}