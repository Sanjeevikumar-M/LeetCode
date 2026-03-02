class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailing = new int[n];

        for(int i=0;i<n;i++){
            int j =n-1;
            while(j>=0 && grid[i][j]==0){
                j--;
            }
            trailing[i] = n-1-j;
        }

        int swaps = 0;

        for(int i=0;i<n;i++){
            int required = n - 1 - i;
            int pos = i;

            while (pos < n && trailing[pos] < required){
                pos++;
            }

            if(pos == n) return -1;

            while (pos > i){
                trailing[pos] = trailing[pos - 1];
                pos--;
                swaps++;
            }
        }
        return swaps;
    }
}