class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        a = []
        for i in range(len(arr)):
            if arr[i] != 0:
                a.append(arr[i])
            else:
                a.append(0)
                a.append(0)
        for i in range(len(arr)):
            arr[i] = a[i]