class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[128];
        
        for(int i=0;i<128;i++){
            hash[i] = -1;
        }

        int left = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(hash[s.charAt(i)] != -1){
                if(hash[s.charAt(i)]>=left){
                    left = 1+hash[s.charAt(i)];
                }
            }
            hash[s.charAt(i)]=i;
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}