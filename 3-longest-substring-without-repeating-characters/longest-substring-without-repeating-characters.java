class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hashtable = new int[128];
        for(int i=0;i<128;i++){
            hashtable[i] = -1;
        }
        int left = 0;
        int max = 0;
        for(int right=0;right<s.length();right++){
            if(hashtable[s.charAt(right)]!=-1){
                if(hashtable[s.charAt(right)]>=left){
                    left = hashtable[s.charAt(right)]+1;
                }
            }
            max = Math.max(max,right-left+1);
            hashtable[s.charAt(right)] = right;
        }
        return max;
    }
}