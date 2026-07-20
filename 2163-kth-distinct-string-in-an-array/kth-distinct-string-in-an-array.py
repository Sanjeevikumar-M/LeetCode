class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        freq = Counter(arr)
        i=0
        for key,value in freq.items():
            if freq[key]==1:
                i+=1
                if i==k:
                    return key
        return ""