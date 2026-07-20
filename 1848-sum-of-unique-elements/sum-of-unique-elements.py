class Solution:
    def sumOfUnique(self, nums: List[int]) -> int:
        freq = {}
        for i in nums:
            freq[i] = freq.get(i,0)+1
        s = 0
        for key,value in freq.items():
            if value == 1:
                s += key
        return s