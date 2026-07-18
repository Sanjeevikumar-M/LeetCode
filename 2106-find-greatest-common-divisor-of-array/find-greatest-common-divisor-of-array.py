class Solution:
    def findGCD(self, nums: List[int]) -> int:
        m = min(nums)
        n = max(nums)

        while n != 0:
            t = n
            n = m%n
            m = t
        

        return m