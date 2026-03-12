import java.util.*;

class Solution {

    class DSU {
        int[] parent, rank;
        int components;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;

            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pb] < rank[pa]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }

            components--;
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        int left = 0;
        int right = 200000; // max possible after upgrade (2 * 1e5)
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canForm(n, edges, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canForm(int n, int[][] edges, int k, int target) {

        DSU dsu = new DSU(n);

        int upgrades = 0;

        // first process mandatory edges
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 1) {
                if (s < target) return false;
                if (!dsu.union(u, v)) return false; // cycle
            }
        }

        // process optional edges
        List<int[]> usable = new ArrayList<>();

        for (int[] e : edges) {
            if (e[3] == 0) usable.add(e);
        }

        // sort by strength descending
        usable.sort((a, b) -> b[2] - a[2]);

        for (int[] e : usable) {

            int u = e[0];
            int v = e[1];
            int s = e[2];

            if (dsu.find(u) == dsu.find(v)) continue;

            if (s >= target) {
                dsu.union(u, v);
            } 
            else if (2 * s >= target && upgrades < k) {
                upgrades++;
                dsu.union(u, v);
            }
        }

        return dsu.components == 1;
    }
}