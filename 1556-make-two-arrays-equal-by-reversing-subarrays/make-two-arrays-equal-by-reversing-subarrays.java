class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] hash = new int[1001];
        for(int i=0;i<target.length;i++){
            hash[target[i]]++;
            hash[arr[i]]--;
        }
        for(int i:hash){
            if(i!=0) return false;
        }
        return true;
    }
}