class Solution:
    def countIslands(self, grid: List[List[int]], k: int) -> int:
        rows = len(grid)
        cols = len(grid[0])
        ans = 0

        def dfs(grid,i,j):
            if i<0 or j<0 or i>=rows or j>=cols or grid[i][j]==0:
                return 0
            s = grid[i][j]
            grid[i][j] = 0
            s += dfs(grid,i,j-1)
            s += dfs(grid,i,j+1)
            s += dfs(grid,i-1,j)
            s += dfs(grid,i+1,j)
            return s
            
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] != 0:
                    s = dfs(grid,i,j)
                    if s%k==0:
                        ans+=1
        return ans