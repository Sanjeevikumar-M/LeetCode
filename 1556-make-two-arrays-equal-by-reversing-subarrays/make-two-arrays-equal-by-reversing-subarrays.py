class Solution:
    def canBeEqual(self, target: list[int], arr: list[int]) -> bool:
        freq = [0]*1001
        for i in arr:
            freq[i]+=1
        for i in target:
            freq[i]-=1
            if freq[i]<0: return False
        return True