class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        res = 0
        count = 0
        for i in s:
            if i=='(':
                count+=1
            else:
                if count>0:
                    count-=1
                else:
                    res += 1
        return count+res