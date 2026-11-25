class Solution:
    def findWords(self, words: list[str]) -> list[str]:
        arr = ['qwertyuiop','asdfghjkl','zxcvbnm']
        res = []
        for i in words:
            for j in arr:
                isValid = True
                for k in i:
                    if k.lower() not in j:
                        isValid = False
                        break
                if isValid:
                    res.append(i)
                    break
        return res