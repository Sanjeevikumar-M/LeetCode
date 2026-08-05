class Solution {
    public boolean checkIfPangram(String sentence) {
        String target = "abcdefghijklmnopqrstuvwxyz";
        for(char ch:target.toCharArray()){
            if(sentence.indexOf(ch) == -1){
                return false;
            }
        }
        return true;
    }
}