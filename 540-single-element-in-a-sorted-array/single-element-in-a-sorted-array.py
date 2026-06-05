class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        map = {}

        for i in nums:
            map[i] = map.get(i,0)+1
        
        for i in map:
            if map[i]==1:
                return i
        
        return -1
