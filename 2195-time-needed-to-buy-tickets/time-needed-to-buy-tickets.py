from collections import deque

class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        queue = deque((i,t) for i,t in enumerate(tickets))
        time = 0
        while queue:
            idx, tickets_left = queue.popleft()
            tickets_left -= 1
            time += 1
            if idx==k and tickets_left==0:
                return time
            if tickets_left>0:
                queue.append((idx,tickets_left))
        return time