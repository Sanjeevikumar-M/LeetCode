class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        i = 0
        n1 = len(word1)
        n2 = len(word2)
        res = ''
        while(i<n1 or i<n2):
            if i<n1:
                res+=word1[i]
            if i<n2:
                res+=word2[i]
            i+=1
        return res