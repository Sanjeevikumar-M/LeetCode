class Solution:
    def reversePrefix(self, s: str, k: int) -> str:
        n = s[:k]
        return n[::-1] + s[k:]