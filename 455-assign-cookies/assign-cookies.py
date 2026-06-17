class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        count = 0
        m = len(g)
        n = len(s)
        g = sorted(g)
        s = sorted(s)
        i,j = 0,0
        while i<m and j<n:
            if g[i]<=s[j]:
                count+=1
                i+=1
                j+=1
            elif g[i]>s[j]:
                j+=1
            
            
        return count