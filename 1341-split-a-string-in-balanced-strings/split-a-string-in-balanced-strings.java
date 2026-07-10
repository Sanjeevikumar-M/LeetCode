class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int t = 0;
        for(char ch:s.toCharArray()){
            if(ch=='R'){
                t++;
            }else{
                t--;
            }
            if(t==0){
                count++;
            }
        }

        return count;
    }
}