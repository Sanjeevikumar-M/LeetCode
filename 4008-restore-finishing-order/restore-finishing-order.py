class Solution:
    def recoverOrder(self, order: List[int], friends: List[int]) -> List[int]:
        f=set(friends)
        return [p for p in order if p in f]