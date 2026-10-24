class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        h = [-1]*128
        l = 0
        m = 0
        for i in range(len(s)):
            ch = ord(s[i])
            if h[ch]!=-1:
                if h[ch]>=l:
                    l = h[ch]+1
            m = max(m,i-l+1)
            h[ch] = i
        return m