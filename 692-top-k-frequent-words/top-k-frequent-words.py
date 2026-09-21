class Solution:
    def topKFrequent(self, words: list[str], k: int) -> list[str]:
        freq = Counter(words)
        res = sorted(freq.keys(), key=lambda w: (-freq[w],w))
        return res[:k]