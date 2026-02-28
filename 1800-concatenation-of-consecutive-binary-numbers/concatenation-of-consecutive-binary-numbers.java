class Solution {
    public int concatenatedBinary(int n) {
        long r = 0;
        int mod = 1000000007;
        int l = 0;
        for(int i=1;i<=n;i++){
            if((i&(i-1))==0){
                l++;
            }
            r=((r<<l)+i) % mod;
        }
        return (int) r;
    }
}