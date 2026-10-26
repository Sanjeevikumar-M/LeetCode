class Solution {
    public int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]>0){
                    long sum = dfs(grid,i,j);
                    if(sum%k==0) count++;
                }
            }
        }
        return count;
    }
    private long dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0){
            return 0;
        }
        long sum = grid[i][j];
        grid[i][j] = 0;
        sum += dfs(grid,i,j-1);
        sum += dfs(grid,i,j+1);
        sum += dfs(grid,i-1,j);
        sum += dfs(grid,i+1,j);
        return sum;
    }
}