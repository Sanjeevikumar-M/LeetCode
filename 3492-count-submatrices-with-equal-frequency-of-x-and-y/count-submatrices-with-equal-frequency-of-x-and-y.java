class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][] sum = new int[n][m];
        int[][] xCount = new int[n][m];

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int val = 0;
                int xVal = 0;

                if (grid[i][j] == 'X') {
                    val = 1;
                    xVal = 1;
                } else if (grid[i][j] == 'Y') {
                    val = -1;
                }

                sum[i][j] = val;
                xCount[i][j] = xVal;

                if (i > 0) {
                    sum[i][j] += sum[i - 1][j];
                    xCount[i][j] += xCount[i - 1][j];
                }
                if (j > 0) {
                    sum[i][j] += sum[i][j - 1];
                    xCount[i][j] += xCount[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    sum[i][j] -= sum[i - 1][j - 1];
                    xCount[i][j] -= xCount[i - 1][j - 1];
                }

                // Check conditions
                if (sum[i][j] == 0 && xCount[i][j] > 0) {
                    result++;
                }
            }
        }

        return result;
    }
}