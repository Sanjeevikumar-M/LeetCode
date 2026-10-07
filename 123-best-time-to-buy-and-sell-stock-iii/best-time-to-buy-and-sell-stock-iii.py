import numpy as np
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        prices = np.array(prices)
        prev_prof = prices - np.minimum.accumulate(prices)
        prev_prof = np.maximum.accumulate(prev_prof)
        prices = prices[::-1]
        next_prof = np.maximum.accumulate(prices) - prices
        next_prof = np.maximum.accumulate(next_prof)
        next_prof = next_prof[::-1]
        return int(np.max(prev_prof + next_prof))