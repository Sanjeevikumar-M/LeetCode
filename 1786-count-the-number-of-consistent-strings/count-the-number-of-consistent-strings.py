class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        count = 0
        for word in words:
            isvalid = True
            for i in word:
                if i not in allowed:
                    isvalid = False
                    break
            if isvalid:
                count+=1
        return count