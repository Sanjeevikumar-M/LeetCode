class Solution:
    def createTargetArray(self, nums: List[int], index: List[int]) -> List[int]:
        res = []
        for val,ind in zip(nums,index):
            res.insert(ind,val)
        return res