import java.util.*;

class Solution {
    private List<Integer>[] adj;
    private int[] depth;
    private int[][] up;
    private int LOG;
    private final int MOD = 1_000_000_007;
    private int[] pow2;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        
        // 1. Calculate the maximum power of 2 needed for binary lifting
        LOG = 0;
        while ((1 << LOG) <= n) {
            LOG++;
        }
        
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        depth = new int[n + 1];
        up = new int[n + 1][LOG];
        
        // 2. Precompute powers of 2 for O(1) retrieval during queries
        pow2 = new int[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }
        
        // 3. Initialize DFS to set depths and immediate parents
        dfs(1, 1, 0);
        
        // 4. Fill the binary lifting table
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }
        
        // 5. Process each query
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            if (u == v) {
                answer[i] = 0;
                continue;
            }
            
            int lcaNode = getLCA(u, v);
            int k = depth[u] + depth[v] - 2 * depth[lcaNode];
            
            // Number of ways is 2^(k-1)
            answer[i] = pow2[k - 1];
        }
        
        return answer;
    }

    private void dfs(int node, int parent, int d) {
        depth[node] = d;
        up[node][0] = parent;
        for (int neighbor : adj[node]) {
            if (neighbor != parent) {
                dfs(neighbor, node, d + 1);
            }
        }
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        
        // Bring both nodes to the same level
        for (int j = LOG - 1; j >= 0; j--) {
            if (depth[u] - (1 << j) >= depth[v]) {
                u = up[u][j];
            }
        }
        
        if (u == v) return u;
        
        // Lift both nodes simultaneously right below their LCA
        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }
        
        return up[u][0];
    }
}