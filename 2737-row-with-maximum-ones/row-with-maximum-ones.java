class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] res = new int[2];
        for(int i=0;i<mat.length;i++){
            int n = maximumOnes(mat[i]);
            if(res[1]<n){
                res[1] = n;
                res[0] = i; 
            }
        }
        return res;
    }

    private static int maximumOnes(int[] arr){
        int count = 0;
        for(int i:arr){
            if(i!=0) count++;
        }
        return count;
    }
}