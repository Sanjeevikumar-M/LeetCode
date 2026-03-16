class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length,n=grid[0].length;

        int[][] diag1 = new int[m+1][n+1];
        int[][] diag2 = new int[m+1][n+2];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                diag1[i+1][j+1] = grid[i][j] + diag1[i][j];
                diag2[i+1][j] = grid[i][j] + diag2[i][j+1];
            }
        }

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                set.add(grid[r][c]);
                for(int k=1; ;k++){
                    if(r-k<0 || r+k>=m ||c-k<0 ||c+k>=n)
                       break;
                    int sum = 0;

                    sum+=diag1[r+1][c+k+1] - diag1[r-k][c];
                    sum+=diag2[r+1][c-k] - diag2[r-k][c+1];
                    sum+=diag1[r+k+1][c+1] - diag1[r][c-k];
                    sum+=diag2[r+k+1][c] - diag2[r][c+k+1];

                    sum-=grid[r-k][c];
                    sum-=grid[r][c+k];
                    sum-=grid[r+k][c];
                    sum-=grid[r][c-k];

                    set.add(sum);
                }
            }
        }
        int size = Math.min(3,set.size());
        int[] res = new int[size];
        int i=0;

        for(int val:set){
            if(i==size) break;
            res[i++]=val;
        }

        return res;
    }
}