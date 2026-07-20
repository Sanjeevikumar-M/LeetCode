class Solution:
    def maxFreqSum(self, s: str) -> int:
        freq = {}
        for i in s:
            freq[i] = freq.get(i,0)+1
        
        cmax = 0
        vmax = 0
        vowels = "aeiou"
        for key,value in freq.items():
            if key in vowels:
                vmax = max(vmax,value)
            else:
                cmax = max(cmax,value)
        
        return vmax+cmax
