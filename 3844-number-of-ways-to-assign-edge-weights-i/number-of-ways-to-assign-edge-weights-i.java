import java.util.ArrayList;
import java.util.List;

class Solution {
    private int maxDepth = 0;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        int MOD = 1_000_000_007;

        // Step 1: Build the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 2: Find the maximum depth using DFS (edges count)
        dfs(1, 0, 0, graph);

        // Step 3: Compute 2^(maxDepth - 1) % MOD
        return power(2, maxDepth - 1, MOD);
    }

    private void dfs(int node, int parent, int currentDepth, List<List<Integer>> graph) {
        maxDepth = Math.max(maxDepth, currentDepth);

        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                dfs(neighbor, node, currentDepth + 1, graph);
            }
        }
    }

    // Fast exponentiation: (base^exp) % mod
    private int power(long base, long exp, int mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return (int) res;
    }
}