class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        n = len(nums)
        mid = n//2

        if pivot not in nums:
            return -1
        else:
            arrless = []
            arrmid = []
            arrgreater = []
            for i in range(0,n):
                if nums[i]<pivot:
                    arrless.append(nums[i])
                elif nums[i]>pivot:
                    arrgreater.append(nums[i])
                else:
                    arrmid.append(nums[i])

            arr = arrless + arrmid + arrgreater
            return arr
