class Solution {
    public int[] findDegrees(int[][] matrix) {
        int[] ans = new int[matrix.length];
        for(int i=0;i<matrix.length;i++){
            int sum = 0;
            for(int j=0;j<matrix[0].length;j++){
                sum += matrix[i][j];
            }
            ans[i]=sum;
        }
        return ans;
    }
}