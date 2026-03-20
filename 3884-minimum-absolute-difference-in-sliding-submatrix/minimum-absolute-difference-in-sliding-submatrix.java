import java.util.*;

class Solution {

    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {

            TreeMap<Integer, Integer> map = new TreeMap<>();
            int minDiff = Integer.MAX_VALUE;

            // build first window (column 0)
            for (int x = i; x < i + k; x++) {
                for (int y = 0; y < k; y++) {
                    minDiff = add(map, grid[x][y], minDiff);
                }
            }

            ans[i][0] = (map.size() <= 1) ? 0 : minDiff;

            // slide window horizontally
            for (int j = 1; j <= n - k; j++) {

                // remove left column
                for (int x = i; x < i + k; x++) {
                    minDiff = remove(map, grid[x][j - 1], minDiff);
                }

                // add right column
                for (int x = i; x < i + k; x++) {
                    minDiff = add(map, grid[x][j + k - 1], minDiff);
                }

                ans[i][j] = (map.size() <= 1) ? 0 : getMinDiff(map);
            }
        }

        return ans;
    }

    // Add element and update minDiff
    private int add(TreeMap<Integer, Integer> map, int val, int minDiff) {
        Integer lower = map.lowerKey(val);
        Integer higher = map.higherKey(val);

        if (lower != null) {
            minDiff = Math.min(minDiff, val - lower);
        }
        if (higher != null) {
            minDiff = Math.min(minDiff, higher - val);
        }

        map.put(val, map.getOrDefault(val, 0) + 1);
        return minDiff;
    }

    // Remove element
    private int remove(TreeMap<Integer, Integer> map, int val, int minDiff) {
        int count = map.get(val);

        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }

        return minDiff; // lazy update
    }

    // Recompute min diff when needed
    private int getMinDiff(TreeMap<Integer, Integer> map) {
        int minDiff = Integer.MAX_VALUE;
        Integer prev = null;

        for (int key : map.keySet()) {
            if (prev != null) {
                minDiff = Math.min(minDiff, key - prev);
            }
            prev = key;
        }

        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
    }
}