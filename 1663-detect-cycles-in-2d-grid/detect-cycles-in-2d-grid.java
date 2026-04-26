class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, i, j, -1, -1, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] grid, int x, int y, int px, int py, boolean[][] visited) {
        visited[x][y] = true;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        for (int[] d : directions) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length
                    && grid[nx][ny] == grid[x][y]) {

                // Skip parent
                if (nx == px && ny == py) continue;

                // If already visited → cycle
                if (visited[nx][ny]) return true;

                // DFS recursion
                if (dfs(grid, nx, ny, x, y, visited)) return true;
            }
        }

        return false;
    }
}