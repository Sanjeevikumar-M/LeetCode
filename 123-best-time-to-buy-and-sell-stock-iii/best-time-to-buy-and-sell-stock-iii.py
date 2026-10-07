class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        buy1 = float('-inf')
        sell1 = 0
        buy2 = float('-inf')
        sell2 = 0
        for i in prices:
            buy1 = max(buy1,-i)
            sell1 = max(sell1,buy1+i)
            buy2 = max(buy2,sell1-i)
            sell2 = max(sell2,buy2+i)
        return sell2