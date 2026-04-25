import java.util.*;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;

        Arrays.sort(points, (a, b) -> Long.compare(map(a, side), map(b, side)));

        int[][] arr = new int[2 * n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = points[i];
            arr[i + n] = points[i];
        }

        int low = 0, high = 2 * side, ans = 0;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (canPick(arr, n, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private long map(int[] p, int side) {
        int x = p[0], y = p[1];

        if (y == 0) return x;
        if (x == side) return side + y;
        if (y == side) return 3L * side - x;
        return 4L * side - y;
    }

    private boolean canPick(int[][] arr, int n, int k, int d) {
        int m = 2 * n;

        int[] next = new int[m];
        int j = 0;

        // build next[] in O(n)
        for (int i = 0; i < m; i++) {
            if (j < i) j = i;
            while (j < m && manhattan(arr[i], arr[j]) < d) j++;
            next[i] = j;
        }

        // binary lifting
        int LOG = 5; // since k <= 25
        int[][] jump = new int[LOG][m];

        for (int i = 0; i < m; i++) jump[0][i] = next[i];

        for (int l = 1; l < LOG; l++) {
            for (int i = 0; i < m; i++) {
                int mid = jump[l - 1][i];
                jump[l][i] = (mid < m) ? jump[l - 1][mid] : m;
            }
        }

        // try ALL starts (this is required)
        for (int i = 0; i < n; i++) {
            int curr = i;
            int need = k - 1;

            // jump k-1 steps
            for (int l = 0; l < LOG; l++) {
                if ((need & (1 << l)) != 0) {
                    curr = jump[l][curr];
                    if (curr >= i + n) break;
                }
            }

            if (curr >= i + n) continue;

            // check circular condition
            if (manhattan(arr[i], arr[curr]) >= d) {
                return true;
            }
        }

        return false;
    }

    private int manhattan(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}