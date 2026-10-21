class Solution:
    def generate(self, numRows: int) -> list[list[int]]:
        if numRows == 0:
            return []
        if numRows == 1:
            return [[1]]
        result = self.generate(numRows-1)
        prerow = result[-1]
        currrow = [1]
        for i in range(1,numRows-1):
            currrow.append(prerow[i-1]+prerow[i])
        currrow.append(1)
        result.append(currrow)
        return result