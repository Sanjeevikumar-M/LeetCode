class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        s = {0:1}
        t = c = 0
        for n in nums:
            t+=n
            c += s.get(t-k,0)
            s[t] = s.get(t,0)+1
        return c