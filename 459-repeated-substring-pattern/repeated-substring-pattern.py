class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        n = len(s)
        for i in range(1,n//2+1):
            if n%i == 0:
                st = s[:i]
                if st * (n//i) == s:
                    return True
        return False