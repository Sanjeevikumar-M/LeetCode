import java.util.*;

public class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        
        // Quick check: if start or end is offline, no path is possible
        if (!online[0] || !online[n - 1]) return -1;
        
        // Find the range of edge costs for binary search
        int low = 0, high = 0;
        for (int[] edge : edges) {
            high = Math.max(high, edge[2]);
        }
        
        int ans = -1;
        
        // Binary search for the maximum possible minimum edge cost
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isValid(n, edges, online, k, mid)) {
                ans = mid;      // mid is possible, try to find a larger minimum
                low = mid + 1;
            } else {
                high = mid - 1; // mid is too high, look for smaller values
            }
        }
        
        return ans;
    }
    
    private boolean isValid(int n, int[][] edges, boolean[] online, long k, int minEdgeCost) {
        // Build adjacency list and calculate in-degrees for the filtered graph
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            
            // Only consider edges between online nodes with cost >= minEdgeCost
            if (online[u] && online[v] && cost >= minEdgeCost) {
                adj.get(u).add(new int[]{v, cost});
                inDegree[v]++;
            }
        }
        
        // DP array to track minimum path cost to each node
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        
        // Kahn's algorithm for Topological Sort
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (online[i] && inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            if (dp[u] != Long.MAX_VALUE) {
                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int cost = neighbor[1];
                    
                    if (dp[u] + cost < dp[v]) {
                        dp[v] = dp[u] + cost;
                    }
                }
            }
            
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        
        // If destination is reachable and total cost is within budget k
        return dp[n - 1] <= k;
    }
}