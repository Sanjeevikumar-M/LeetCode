class Solution {
    int rows, cols;
    int islands = 0;

    public int numIslands(char[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            check(grid, row);
        }

        return islands;
    }

    public void check(char[][] grid, int row) {

        for (int col = 0; col < cols; col++) {

            if (grid[row][col] == '1') {

                islands++;
                dfs(grid, row, col);
            }
        }
    }

    public void dfs(char[][] grid, int row, int col) {

        grid[row][col] = '*';

        if (row > 0 && grid[row - 1][col] == '1')
            dfs(grid, row - 1, col);

        if (row + 1 < rows && grid[row + 1][col] == '1')
            dfs(grid, row + 1, col);

        if (col > 0 && grid[row][col - 1] == '1')
            dfs(grid, row, col - 1);

        if (col + 1 < cols && grid[row][col + 1] == '1')
            dfs(grid, row, col + 1);
    }
} 