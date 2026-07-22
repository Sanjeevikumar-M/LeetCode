class Solution:
    def threeSumMulti(self, arr: List[int], target: int) -> int:
        count = [0]*101
        for i in arr:
            count[i]+=1
        MOD = 1_000_000_007
        ans = 0
        for i in range(101):
            for j in range(i,101):
                k = target-i-j
                if k<j or k>100:
                    continue
                if count[i]==0 or count[j]==0 or count[k]==0:
                    continue

                if i==j and j==k:
                    ans += count[i]*(count[i]-1)*(count[k]-2)//6
                elif i==j and j!=k:
                    ans += count[i]*(count[i]-1)//2*count[k]
                elif i!=j and j==k:
                    ans += count[i]*count[j]*(count[j]-1)//2
                else:
                    ans += count[i]*count[j]*count[k]
                
                ans %= MOD
        return ans