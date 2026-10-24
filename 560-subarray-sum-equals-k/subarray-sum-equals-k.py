class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        s = {0:1}
        t = c = 0
        for n in nums:
            t+=n
            if t-k in s:
                c += s[t-k]
            s[t] = s.get(t,0)+1
        return c