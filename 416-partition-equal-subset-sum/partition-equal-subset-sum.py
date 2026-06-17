class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total_sum = sum(nums)
        
        # If total sum is odd, we cannot partition it equally
        if total_sum % 2 != 0:
            return False
            
        target = total_sum // 2
        
        # dp set stores all unique subset sums possible so far
        dp = {0}
        
        for num in nums:
            # Create new sums by adding the current number to all existing sums
            next_dp = set()
            for current_sum in dp:
                new_sum = current_sum + num
                if new_sum == target:
                    return True
                if new_sum < target:
                    next_dp.add(new_sum)
            
            # Update the dp set with new valid sums
            dp.update(next_dp)
            
        return target in dp