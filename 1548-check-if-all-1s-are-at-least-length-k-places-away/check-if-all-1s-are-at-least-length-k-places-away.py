class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        count = 0
        try:
            i = nums.index(1)
        except ValueError:
            return True
        for num in nums[i+1:]:
            if num==1:
                if count<k:
                    return False
                count=0
            else:
                count+=1
        return True