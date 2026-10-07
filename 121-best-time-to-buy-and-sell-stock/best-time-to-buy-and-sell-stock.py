class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        mini = float('inf')
        maxi = 0
        for i in prices:
            mini = min(i,mini)
            n = i-mini
            maxi = max(maxi,n)
        return maxi