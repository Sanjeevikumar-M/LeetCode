class Solution:
    def recoverOrder(self, order: List[int], friends: List[int]) -> List[int]:
        
        friends_set = set(friends)

        return [player for player in order if player in friends_set]