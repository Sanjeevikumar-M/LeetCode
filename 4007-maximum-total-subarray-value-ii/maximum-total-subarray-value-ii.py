import heapq
import math

class Solution:
    def maxTotalValue(self, nums: List[int], k: int) -> int:
        n = len(nums)

        LOG = math.floor(math.log2(n)) + 1
        st_max = [[0] * n for _ in range(LOG)]
        st_min = [[0] * n for _ in range(LOG)]
        
        for j in range(n):
            st_max[0][j] = nums[j]
            st_min[0][j] = nums[j]
            
        for i in range(1, LOG):
            for j in range(n - (1 << i) + 1):
                st_max[i][j] = max(st_max[i-1][j], st_max[i-1][j + (1 << (i-1))])
                st_min[i][j] = min(st_min[i-1][j], st_min[i-1][j + (1 << (i-1))])
                
        def query_value(l, r):
            length = r - l + 1
            i = math.floor(math.log2(length))
            mx = max(st_max[i][l], st_max[i][r - (1 << i) + 1])
            mn = min(st_min[i][l], st_min[i][r - (1 << i) + 1])
            return mx - mn

        max_heap = []
        for l in range(n):
            val = query_value(l, n - 1)
            heapq.heappush(max_heap, (-val, l, n - 1))
            
        total_value = 0
        
        for _ in range(k):
            if not max_heap:
                break
                
            neg_val, l, r = heapq.heappop(max_heap)
            total_value += (-neg_val)
            
            if r > l:
                next_val = query_value(l, r - 1)
                heapq.heappush(max_heap, (-next_val, l, r - 1))
                
        return total_value