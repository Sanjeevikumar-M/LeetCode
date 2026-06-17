class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        r = ''
        i = 0
        incr = k*2
        while i<len(s):
            curr = s[i:i+k] 
            r += curr[::-1] + s[i+k:i+incr]
            i+=incr
        return r