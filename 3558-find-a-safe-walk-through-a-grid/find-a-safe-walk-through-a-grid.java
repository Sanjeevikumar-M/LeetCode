class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = grid.get(0).get(0);
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0,0});

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while(!deque.isEmpty()){
            int[] curr = deque.pollFirst();
            int r = curr[0];
            int c = curr[1];

            if(r==m-1 && c==n-1){
                break;
            }

            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int weight = grid.get(nr).get(nc);
                    int nextCost = dist[r][c] + weight;

                    if(nextCost<dist[nr][nc]){
                        dist[nr][nc] = nextCost;

                        if(weight==0){
                            deque.offerFirst(new int[]{nr,nc});
                        }else{
                            deque.offerLast(new int[]{nr,nc});
                        }
                    }
                }
            }
        }
        int finalWeight = dist[m-1][n-1];

        return health-finalWeight > 0;
    }
}