class Solution:
    def getRow(self, rowIndex: int) -> list[int]:
        res = []
        val = 1
        for r in range(rowIndex+1):
            res.append(val)
            val = val*(rowIndex-r)//(r+1)
        return res