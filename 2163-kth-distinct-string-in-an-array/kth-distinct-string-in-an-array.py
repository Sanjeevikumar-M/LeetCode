class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        freq = {}
        for i in arr:
            freq[i] = freq.get(i,0)+1
        
        i=1
        for key,value in freq.items():
            if value<2 and i==k:
                return key
            elif value<2:
                i+=1
        return ""