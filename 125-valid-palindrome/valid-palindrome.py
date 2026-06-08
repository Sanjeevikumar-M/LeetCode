class Solution:
    def isPalindrome(self, s: str) -> bool:
        n = []
        m = []
        for i in range(len(s)):
            if s[i].isalpha() or s[i].isdigit():
                m.append(s[i].lower())
        for i in range(len(s)-1,-1,-1):
            if s[i].isalpha() or s[i].isdigit():
                n.append(s[i].lower())
        n = "".join(n)
        l = "".join(m)
        return l==n