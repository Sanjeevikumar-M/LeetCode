class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        left = 0
        right = len(arr)-1
        while left<=right:
            if arr[left]==arr[right] and left==right:
                return left

            elif arr[left]<=arr[right]:
                left += 1

            else:
                right -= 1

        return -1

