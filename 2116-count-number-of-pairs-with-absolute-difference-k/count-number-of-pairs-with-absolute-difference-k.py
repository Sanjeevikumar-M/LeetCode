class Solution:
    def countKDifference(self, nums: List[int], k: int) -> int:
        c = 0
        b = [0]*101
        for i in nums:
            b[i]+=1
        for i in range(1+k,101):
            c+= b[i]*b[i-k]
        return c