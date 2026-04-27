import java.util.*;

class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Directions: {dx, dy}
        int[][] dirs = {
            {0, -1}, // left
            {0, 1},  // right
            {-1, 0}, // up
            {1, 0}   // down
        };

        // Allowed directions per street type
        int[][][] moves = {
            {},
            {{0, -1}, {0, 1}},   // 1
            {{-1, 0}, {1, 0}},   // 2
            {{0, -1}, {1, 0}},   // 3
            {{0, 1}, {1, 0}},    // 4
            {{0, -1}, {-1, 0}},  // 5
            {{0, 1}, {-1, 0}}    // 6
        };

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1];

            if (i == m - 1 && j == n - 1) return true;

            int type = grid[i][j];

            for (int[] d : moves[type]) {
                int ni = i + d[0];
                int nj = j + d[1];

                if (ni < 0 || nj < 0 || ni >= m || nj >= n || visited[ni][nj])
                    continue;

                int nextType = grid[ni][nj];

                // Check if next cell connects back
                for (int[] back : moves[nextType]) {
                    if (ni + back[0] == i && nj + back[1] == j) {
                        visited[ni][nj] = true;
                        q.offer(new int[]{ni, nj});
                        break;
                    }
                }
            }
        }

        return false;
    }
}