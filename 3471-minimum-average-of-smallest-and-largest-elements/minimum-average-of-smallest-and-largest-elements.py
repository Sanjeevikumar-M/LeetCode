class Solution:
    def minimumAverage(self, nums: List[int]) -> float:
        mi = float('inf')
        for i in range(len(nums)//2):
            minn = min(nums)
            maxx = max(nums)
            avg = (minn+maxx)/2
            mi = min(mi,avg)
            nums.remove(minn)
            nums.remove(maxx)
        return mi