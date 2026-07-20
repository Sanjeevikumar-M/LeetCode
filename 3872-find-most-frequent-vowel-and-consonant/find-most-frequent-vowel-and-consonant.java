class Solution {
    public int maxFreqSum(String s) {
        int[] fq = new int[26];
        for(char c:s.toCharArray()){
            fq[c-'a']++;
        }
        int maxv = 0, maxc = 0;
        for(int i=0; i<26; i++){
            int f = fq[i];
            if((i==0 || i==4 || i==8 || i==14 || i==20)){
                if(maxv<f) maxv = f;
            }
            else if(maxc < f) maxc = f;
        }
        return maxv + maxc;
    }
}