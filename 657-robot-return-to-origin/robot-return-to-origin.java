class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        int[] p = new int[2];
        for(int i=0;i<n;i++){
            char ch = moves.charAt(i);
            if(ch=='U'){
                p[0]++;
            }
            else if(ch=='D'){
                p[0]--;
            }else if(ch=='R'){
                p[1]++;
            }else{
                p[1]--;
            }
        }
        for(int i:p){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}