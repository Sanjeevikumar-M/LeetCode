import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Step 1: Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponentsCount = 0;

        // Step 2: Traverse each component
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (isComplete(i, adj, visited)) {
                    completeComponentsCount++;
                }
            }
        }

        return completeComponentsCount;
    }

    private boolean isComplete(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        int nodeCount = 0;
        int totalDegrees = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            nodeCount++;
            totalDegrees += adj.get(curr).size();

            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        // Total unique edges in this undirected component
        int edgeCount = totalDegrees / 2;

        // Check if the component is complete
        return edgeCount == (nodeCount * (nodeCount - 1)) / 2;
    }
}