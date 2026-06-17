class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        s.sort()
        g.sort()
        l = 0
        cookiesLen = len(s)
        r = 0
        childLen = len(g)
        outCount = 0
        while(l<cookiesLen and r<childLen):
            if(s[l]>=g[r]):
                l = l+1
                r = r+1
                outCount = outCount+1
            else:
                l = l+1
        return outCount 