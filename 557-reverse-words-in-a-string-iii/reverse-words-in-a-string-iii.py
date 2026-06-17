class Solution:
    def reverseWords(self, s: str) -> str:
        w = list(s.split(" "))
        r = ""
        for i in w:
            r += i[::-1] + " "
        return r[:-1]