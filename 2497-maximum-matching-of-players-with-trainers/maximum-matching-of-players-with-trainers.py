class Solution:
    def matchPlayersAndTrainers(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        n=len(g)
        j=0
        for i in s:
            if j<n and g[j]<=i:
                j+=1
            
        return j