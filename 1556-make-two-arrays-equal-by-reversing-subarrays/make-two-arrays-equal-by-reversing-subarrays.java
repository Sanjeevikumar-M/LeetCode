class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] hash = new int[1001];
        for(int i:arr){
            hash[i]++;
        }
        for(int i:target){
            hash[i]--;
            if(hash[i]<0) return false;
        }
        return true;
    }
}