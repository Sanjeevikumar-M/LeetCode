class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
        matches = 0

        players.sort(reverse=True)
        trainers.sort(reverse=True)

        for p in players:
            if not trainers or p > trainers[0]:
                continue # player can't be matched
            matches += 1
            trainers.pop(0)
        return matches