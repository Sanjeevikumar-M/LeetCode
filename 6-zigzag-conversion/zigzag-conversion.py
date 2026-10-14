class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows==1 or numRows>len(s):
            return s
        l = ['']*numRows
        downDir = False
        curr = 0
        for i in s:
            l[curr] += i
            if curr==0 or curr==numRows-1:
                downDir = not downDir
            curr += 1 if downDir else -1
        return ''.join(l)
