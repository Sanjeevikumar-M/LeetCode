class Solution:
    def maxBuilding(self, n: int, restrictions: List[List[int]]) -> int:
        # 1. Add the boundary restrictions: 
        # Building 1 always has max height 0. 
        # Building n has no initial limit (can go up to n-1).
        restrictions.append([1, 0])
        restrictions.append([n, n - 1])
        
        # 2. Sort restrictions by building ID
        restrictions.sort()
        
        m = len(restrictions)
        
        # 3. Forward Pass: Left to Right propagation
        for i in range(m - 1):
            x1, h1 = restrictions[i]
            x2, h2 = restrictions[i + 1]
            restrictions[i + 1][1] = min(h2, h1 + (x2 - x1))
            
        # 4. Backward Pass: Right to Left propagation
        for i in range(m - 1, 0, -1):
            x1, h1 = restrictions[i]
            x2, h2 = restrictions[i - 1]
            restrictions[i - 1][1] = min(h2, h1 + (x1 - x2))
            
        # 5. Calculate the absolute max height possible between any two restricted buildings
        max_height = 0
        for i in range(m - 1):
            x1, h1 = restrictions[i]
            x2, h2 = restrictions[i + 1]
            
            # Formula to find the absolute highest peak between x1 and x2
            peak = (h1 + h2 + (x2 - x1)) // 2
            max_height = max(max_height, peak)
            
        return max_height