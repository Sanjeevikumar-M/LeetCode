class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int row = 0, max = 0;
        int n = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < col; j++) {
                count += mat[i][j];

            }

            if (count > max) {
                row = i;
                max = count;
            }
        }

        return new int[] { row, max };
    }
}