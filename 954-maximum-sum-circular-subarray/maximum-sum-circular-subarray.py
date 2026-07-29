class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        total_sum = 0

        c_max = 0
        g_max = nums[0]

        current_min = 0
        global_min = nums[0]

        for i in nums:
            total_sum += i

            c_max = max(i,c_max+i)
            g_max = max(g_max,c_max)

            current_min = min(i, current_min + i)
            global_min = min(global_min, current_min)
        
        if g_max < 0:
            return g_max
    
        return max(g_max,total_sum-global_min)