class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
        players.sort()
        trainers.sort()
        i,j = 0,0
        count = 0
        m,n = len(players),len(trainers)
        while i<m and j<n:
            if players[i]<=trainers[j]:
                count+=1
                i+=1
                j+=1
            elif players[i]>trainers[j]:
                j+=1
        return count