class Solution {
    public int balancedStringSplit(String s) {
        int i = 0;
        int j = 0;
        int count = 0;
        int countR = 0;
        int countL = 0;
        while(j<s.length()){
            if(s.charAt(j)=='R'){
                countR++;
            }else{
                countL++;
            }
            
            if(s.charAt(i)!=s.charAt(j) && countR==countL){
                count++;
                countR=0;
                countL=0;
                i = j+1;
            }
            j++;
        }

        return count;
    }
}