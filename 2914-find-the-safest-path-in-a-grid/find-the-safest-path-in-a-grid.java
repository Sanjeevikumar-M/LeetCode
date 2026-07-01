import java.util.*;

class Solution {
    // Direction vectors for moving up, down, left, and right
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        // Edge case: If start or end contains a thief, safeness factor is 0
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        // Step 1: Multi-Source BFS to compute minimum distance to any thief
        int[][] safeness = new int[n][n];
        for (int[] row : safeness) {
            Arrays.fill(row, -1);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        // Find all thieves and add them to the queue
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    safeness[r][c] = 0;
                    queue.offer(new int[]{r, c});
                }
            }
        }
        
        // Propagate distances layer by layer
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            
            for (int[] dir : DIRECTIONS) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // If neighbor is valid and unvisited
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && safeness[nr][nc] == -1) {
                    safeness[nr][nc] = safeness[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // Step 2: Modified Dijkstra's Algorithm using a Max-Heap
        // Max-Heap stores element as [safeness_factor, row, col], sorted by safeness descending
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        boolean[][] visited = new boolean[n][n];
        
        // Push the starting cell
        maxHeap.offer(new int[]{safeness[0][0], 0, 0});
        visited[0][0] = true;
        
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int currentSafeness = curr[0];
            int r = curr[1];
            int c = curr[2];
            
            // If we reached the bottom-right corner, we found our optimal path
            if (r == n - 1 && c == n - 1) {
                return currentSafeness;
            }
            
            for (int[] dir : DIRECTIONS) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    // The safeness of the path is restricted by the minimum safeness encountered so far
                    int nextSafeness = Math.min(currentSafeness, safeness[nr][nc]);
                    maxHeap.offer(new int[]{nextSafeness, nr, nc});
                }
            }
        }
        
        return 0;
    }
}