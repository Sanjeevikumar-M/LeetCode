import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) return 0;

        int[][] safeness = new int[n][n];
        for (int[] row : safeness) Arrays.fill(row, -1);
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    safeness[r][c] = 0;
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] d : dirs) {
                int nr = curr[0] + d[0], nc = curr[1] + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && safeness[nr][nc] == -1) {
                    safeness[nr][nc] = safeness[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        maxHeap.offer(new int[]{safeness[0][0], 0, 0});
        safeness[0][0] = -1; // Mark as visited directly in the safeness array

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int s = curr[0], r = curr[1], c = curr[2];

            if (r == n - 1 && c == n - 1) return s;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && safeness[nr][nc] != -1) {
                    maxHeap.offer(new int[]{Math.min(s, safeness[nr][nc]), nr, nc});
                    safeness[nr][nc] = -1; // Mark visited
                }
            }
        }
        return 0;
    }
}