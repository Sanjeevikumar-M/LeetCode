class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        num_set = set(nums)
        m = 0
        for num in num_set:
            if num-1 not in num_set:
                cnum = num
                count = 1
                
                while cnum+1 in num_set:
                    count+=1
                    cnum+=1
                m = max(m,count)
        return m  
