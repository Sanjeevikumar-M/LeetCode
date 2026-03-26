class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long total = 0;
        for (int[] row : grid)
            for (int v : row)
                total += v;

        // --- Horizontal cuts ---
        Map<Long, Integer> bottom = new HashMap<>();
        for (int[] row : grid)
            for (int v : row)
                bottom.merge((long) v, 1, Integer::sum);

        Map<Long, Integer> top = new HashMap<>();
        long topSum = 0;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                long v = grid[i][j];
                topSum += v;
                top.merge(v, 1, Integer::sum);
                bottom.merge(v, -1, Integer::sum);
                if (bottom.get(v) == 0) bottom.remove(v);
            }
            long bottomSum = total - topSum;
            if (checkValid(grid, top, bottom, topSum, bottomSum, true, i))
                return true;
        }

        // --- Vertical cuts ---
        Map<Long, Integer> right = new HashMap<>();
        for (int[] row : grid)
            for (int v : row)
                right.merge((long) v, 1, Integer::sum);

        Map<Long, Integer> left = new HashMap<>();
        long leftSum = 0;

        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                long v = grid[i][j];
                leftSum += v;
                left.merge(v, 1, Integer::sum);
                right.merge(v, -1, Integer::sum);
                if (right.get(v) == 0) right.remove(v);
            }
            long rightSum = total - leftSum;
            if (checkValid(grid, left, right, leftSum, rightSum, false, j))
                return true;
        }

        return false;
    }

    private boolean checkValid(int[][] grid,
                                Map<Long, Integer> freqA, Map<Long, Integer> freqB,
                                long sumA, long sumB,
                                boolean horizontal, int cut) {
        if (sumA == sumB) return true;

        int m = grid.length, n = grid[0].length;
        int rowsA, colsA, rowsB, colsB;
        if (horizontal) {
            rowsA = cut + 1;     colsA = n;
            rowsB = m - cut - 1; colsB = n;
        } else {
            rowsA = m; colsA = cut + 1;
            rowsB = m; colsB = n - cut - 1;
        }

        if (sumA > sumB) {
            long diff = sumA - sumB;
            return freqA.containsKey(diff)
                && hasRemovableCell(grid, diff, horizontal, cut, true, rowsA, colsA);
        } else {
            long diff = sumB - sumA;
            return freqB.containsKey(diff)
                && hasRemovableCell(grid, diff, horizontal, cut, false, rowsB, colsB);
        }
    }

    private boolean hasRemovableCell(int[][] grid, long diff,
                                     boolean horizontal, int cut, boolean isA,
                                     int rows, int cols) {
        int m = grid.length, n = grid[0].length;

        // 2D section: any single cell removal keeps it connected
        if (rows >= 2 && cols >= 2) return true;

        // 1x1: can't remove the only cell
        if (rows == 1 && cols == 1) return false;

        // 1D strip: compute endpoints
        int r0, r1, c0, c1;
        if (horizontal) {
            c0 = 0; c1 = n - 1;
            if (isA) { r0 = 0;       r1 = cut;   }
            else     { r0 = cut + 1; r1 = m - 1; }
        } else {
            r0 = 0; r1 = m - 1;
            if (isA) { c0 = 0;       c1 = cut;   }
            else     { c0 = cut + 1; c1 = n - 1; }
        }

        if (rows == 1) {
            return grid[r0][c0] == diff || grid[r0][c1] == diff;
        } else { // cols == 1
            return grid[r0][c0] == diff || grid[r1][c0] == diff;
        }
    }
}