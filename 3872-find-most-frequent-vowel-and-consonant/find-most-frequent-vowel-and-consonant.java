class Solution {
    public int maxFreqSum(String s) {
        int[] fr = new int[26];
        for(char i:s.toCharArray()){
            fr[i-'a']++;
        }
        int maxv = 0,maxc = 0;
        for(int i=0;i<fr.length;i++){
            if(i==0 || i==4 || i==8 || i==14 || i==20){
                if(maxv<fr[i]) maxv = fr[i];
            }else{
                if(maxc<fr[i]) maxc = fr[i];
            }
        }
        return maxc+maxv;
    }
}