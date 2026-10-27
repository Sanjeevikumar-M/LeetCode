class Solution:
    def createGrid(self, m: int, n: int) -> List[str]:
        return ['.' + '#' * (n - 1)] * (m - 1) + ['.' * n]