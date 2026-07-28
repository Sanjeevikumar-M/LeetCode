class Solution {
    public int findLucky(int[] arr) {
        int[] num = new int[501];
        for(int i:arr){
            num[i]++;
        }
        int n = -1;
        for(int i=0;i<num.length;i++){
            if(i==num[i]){
                n = Math.max(n,i);
            }
        }
        return n==0 ? -1:n;
    }
}