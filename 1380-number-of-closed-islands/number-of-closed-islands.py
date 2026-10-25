class Solution:
    def closedIsland(self, grid: list[list[int]]) -> int:
        def dfs(grid: list[list[int]], i: int, j: int) -> bool:
            if i<0 or j<0 or i>=len(grid) or j>=len(grid[0]):
                return False
            if grid[i][j] == 1:
                return True
            grid[i][j] = 1
            right = dfs(grid,i,j+1)
            left = dfs(grid,i,j-1)
            top = dfs(grid,i-1,j)
            bottom = dfs(grid,i+1,j)
            return right and left and top and bottom
        rows = len(grid)
        cols = len(grid[0])
        count = 0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 0 and dfs(grid,i,j):
                    count+=1
        return count