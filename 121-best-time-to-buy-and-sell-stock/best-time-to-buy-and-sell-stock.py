class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        minp = float('inf')
        maxp = 0
        for price in prices:
            if price<minp:
                minp = price
            elif price - minp > maxp:
                maxp = price-minp
        return maxp