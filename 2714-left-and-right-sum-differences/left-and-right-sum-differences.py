class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        # 1. Calculate the total sum of the array
        right_sum = sum(nums)
        left_sum = 0
        answer = []
        
        # 2. Iterate through each element
        for num in nums:
            # Shift the current element out of the right side sum
            right_sum -= num
            
            # Calculate the absolute difference and store it
            answer.append(abs(left_sum - right_sum))
            
            # Shift the current element into the left side sum for the next iteration
            left_sum += num
            
        return answer