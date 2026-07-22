class Solution:
    def maxActiveSectionsAfterTrade(self, s: str) -> int:
        totalOnes = 0
        for i in s:
            if i == '1':
                totalOnes += 1
        
        t = '1'+s+'1'
        arr = []
        i = 0
        n = len(t)
        while i<n:
            if t[i] == '1':
                while i<n and t[i] == '1':
                    i+=1
            else:
                start = i
                while i<n and t[i] == '0':
                    i+=1
                arr.append(i-start)
        m = 0
        for i in range(len(arr)-1):
            gain = arr[i]+arr[i+1]
            m = max(m,gain)
        return m+totalOnes