class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] count = new int[101];
        int c = 0;
        for(int i:nums){
            count[i]++;
            if(count[i]==2){
                c++;
            }
        }
        int[] res = new int[c];
        int j = 0;
        for(int i=0;i<101;i++){
            if(count[i]==2){
                res[j] = i;
                j++;
            }
        }
        return res;
    }
}