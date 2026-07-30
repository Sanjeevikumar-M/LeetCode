class Solution {
    public int minimumPushes(String word) {
        //int n = word.length();
        // if(n<=8){
        //     return n;
        // }else if(n <= 8*2){
        //     return 8+(n-8)*2;
        // }else if(n <= 8*3){
        //     return (n-8)*3;
        // }else{
        //     return 16 + (n-16)*4;
        // }
        return 8 * (word.length()/8) * (word.length()/8 + 1)/2 + (word.length()/8 + 1) * (word.length()%8);
    }
}