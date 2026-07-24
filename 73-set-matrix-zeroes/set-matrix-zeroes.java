class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[] rowHasZero = new boolean[row];
        boolean[] colHasZero = new boolean[col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == 0){
                    rowHasZero[i] = true;
                    colHasZero[j] = true;
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rowHasZero[i] == true || colHasZero[j] == true){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}