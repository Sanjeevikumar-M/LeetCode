class Solution:
    def sumOddLengthSubarrays(self, arr: List[int]) -> int:
        total1=0
        for i in range(0,len(arr)):
            subarray=(i+1)*(len(arr)-i)
            odd=(subarray+1)//2
            total=arr[i]*odd
            total1+=total
        return total1       
        