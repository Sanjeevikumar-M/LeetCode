import java.util.List;

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        int[][] maxScore = new int[n][n];
        int[][] pathCount = new int[n][n];

        // Base case: Start at the bottom-right 'S'
        pathCount[n - 1][n - 1] = 1;

        // Iterate backwards from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Skip if it's an obstacle or if the current cell is unreachable
                if (board.get(i).charAt(j) == 'X' || pathCount[i][j] == 0) {
                    continue;
                }

                // Directions to move: Up, Left, Up-Left (from current cell's perspective)
                // Looking at it backward, we transition TO: (i-1, j), (i, j-1), (i-1, j-1)
                int[] nextRows = {i - 1, i, i - 1};
                int[] nextCols = {j, j - 1, j - 1};

                for (int d = 0; d < 3; d++) {
                    int ni = nextRows[d];
                    int nj = nextCols[d];

                    // Check boundaries and avoid obstacles
                    if (ni >= 0 && nj >= 0 && board.get(ni).charAt(nj) != 'X') {
                        char cellChar = board.get(ni).charAt(nj);
                        int cellValue = (cellChar == 'E') ? 0 : (cellChar - '0');
                        int newScore = maxScore[i][j] + cellValue;

                        if (newScore > maxScore[ni][nj]) {
                            maxScore[ni][nj] = newScore;
                            pathCount[ni][nj] = pathCount[i][j];
                        } else if (newScore == maxScore[ni][nj]) {
                            pathCount[ni][nj] = (pathCount[ni][nj] + pathCount[i][j]) % MOD;
                        }
                    }
                }
            }
        }

        // Return results from the target destination 'E' at (0, 0)
        return new int[]{maxScore[0][0], pathCount[0][0]};
    }
}