class Solution:
    def recoverOrder(self, order: List[int], friends: List[int]) -> List[int]:
        l = []
        for i in range(len(order)):
            if order[i] in friends:
                l.append(order[i])
        return l