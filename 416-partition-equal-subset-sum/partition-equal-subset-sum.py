class Solution:
    def canPartition(self, nums: list[int]) -> bool:
        tot=sum(nums)
        if (tot%2)!=0:
            return False

        target=tot>>1
        bits=1
        
        for num in nums:
            bits |= bits<<num
            
        return (bits>>target) & 1==1