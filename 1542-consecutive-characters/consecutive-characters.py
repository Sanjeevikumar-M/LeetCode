class Solution:
    def maxPower(self, s: str) -> int:
        count = 1
        m = 1
        curr = s[0]
        for i in range(1,len(s)):
            if s[i]==curr:
                count+=1
            else:
                m = max(m,count)
                count = 1
                curr = s[i]
        return max(m,count)
