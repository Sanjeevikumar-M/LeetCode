class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        s = s.strip()
        w = list(s.split(" "))
        return len(w[-1])