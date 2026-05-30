import java.util.*;

class Solution {

    static class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        private void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val;
                return;
            }

            int mid = (l + r) >> 1;

            if (idx <= mid)
                update(node * 2, l, mid, idx, val);
            else
                update(node * 2 + 1, mid + 1, r, idx, val);

            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int query(int L, int R) {
            if (L > R) return 0;
            return query(1, 0, n - 1, L, R);
        }

        private int query(int node, int l, int r, int L, int R) {
            if (L <= l && r <= R) return tree[node];
            if (r < L || l > R) return 0;

            int mid = (l + r) >> 1;

            return Math.max(
                query(node * 2, l, mid, L, R),
                query(node * 2 + 1, mid + 1, r, L, R)
            );
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        final int MAX = 50001;

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(MAX);

        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }

        SegmentTree seg = new SegmentTree(MAX + 1);

        int prev = 0;
        for (int pos : obstacles) {
            seg.update(pos, pos - prev);
            prev = pos;
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];

            if (q[0] == 1) {
                int x = q[1];

                int left = obstacles.lower(x);
                int right = obstacles.higher(x);

                obstacles.remove(x);

                seg.update(x, 0);
                seg.update(right, right - left);

            } else {
                int x = q[1];
                int sz = q[2];

                int pre = obstacles.floor(x);

                int bestGapBefore = seg.query(0, pre);
                int tailGap = x - pre;

                ans.add(Math.max(bestGapBefore, tailGap) >= sz);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}