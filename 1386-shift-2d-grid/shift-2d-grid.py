class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        l,m,n,k = [num for row in grid for num in row], len(grid), len(grid[0]), k%(len(grid)*len(grid
        [0]))
        l = l[-k:] + l[:-k]
        return [l[i*n:i*n+n] for i in range(m)]