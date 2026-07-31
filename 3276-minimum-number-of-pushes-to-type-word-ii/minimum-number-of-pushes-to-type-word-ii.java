class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for(char i:word.toCharArray()){
            count[i-'a']++;
        }
        Arrays.sort(count);
        int pushes = 0;
        for(int i=25;i>=0;i--){
            if(i>17){
                pushes+= count[i];
            }else if(i>9){
                pushes+= (count[i]*2);
            }else if(i>1){
                pushes += (count[i]*3);
            }else{
                pushes += (count[i]*4);
            }
        }
        return pushes;
    }
}