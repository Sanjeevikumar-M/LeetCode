class Solution:
    def isPalindrome(self, s: str) -> bool:
        n = []
        for i in range(len(s)-1,-1,-1):
            if s[i].isalnum():
                n.append(s[i].lower())
        n = "".join(n)
        return n==n[::-1]
        