class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        topthree = set()
        for i in nums:
            topthree.add(i)
            if len(topthree)>3:
                mi = min(topthree)
                topthree.remove(mi)
        if len(topthree)<3:
            return max(topthree)
        else:
            return min(topthree)
                
            
        