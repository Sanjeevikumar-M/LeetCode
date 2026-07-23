class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    sum += mat[i][j];
                    continue;
                }
                if(i+j+1 == m){
                    sum += mat[i][j];
                    continue;
                }
            }
        }
        return sum;
    }
}