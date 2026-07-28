class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int[][] mat = new int[n][n];
        int e = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = e;
                e++;
            }
        }
        int ans = mat[0][0];
        int row = 0;
        int col = 0;
        for(String s:commands){
            if(s.equals("RIGHT")){
                ans = mat[row][++col];
            }else if(s.equals("LEFT")){
                ans = mat[row][--col];
            }else if(s.equals("UP")){
                ans = mat[--row][col];
            }else if(s.equals("DOWN")){
                ans = mat[++row][col];
            }
        }
        return ans;
    }
}