class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int num = 1;

        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;

        while(top<=bottom && left<=right){
            for(int row=left;row<=right;row++){
                res[top][row] = num++;
            }
            top++;

            for(int col=top;col<=bottom;col++){
                res[col][right] = num++;
            }
            right--;

            if(top<=bottom){
                for(int row=right;row>=left;row--){
                    res[bottom][row] = num++;
                }
                bottom--;
            }

            if(left<=right){
                for(int col=bottom;col>=top;col--){
                    res[col][left] = num++;
                }
                left++;
            }
        }

        return res;
    }
}