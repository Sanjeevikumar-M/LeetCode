class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        freq = Counter(nums)
        res = sorted(freq.keys(), key=lambda w: (-freq[w],w))
        return res[:k]