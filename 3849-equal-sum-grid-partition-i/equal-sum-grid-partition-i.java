class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;

        // Step 1: Compute total sum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }

        // Step 2: Check horizontal cuts
        long rowSum = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum == total - rowSum) {
                return true;
            }
        }

        // Step 3: Check vertical cuts
        long colSum = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                colSum += grid[i][j];
            }
            if (colSum == total - colSum) {
                return true;
            }
        }

        return false;
    }
}