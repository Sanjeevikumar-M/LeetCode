class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        curr_index = 0
        for i in range(len(nums)):
            if nums[i]==1:
                curr_index=i
                break
        for i in range(curr_index+1,len(nums)):
            if nums[i]==1:
                diff = i-(curr_index+1)
                if diff<k:
                    return False
                curr_index=i
                    
        return True