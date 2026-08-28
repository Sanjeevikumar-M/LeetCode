class Solution {
    private boolean isPrime(int n) {
        if (n<=1) return false;
        for (int i=2;i*i<=n;i++) {
            if (n%i==0) return false;
        }
        return true;
    }
    public int diagonalPrime(int[][] nums) {
        int maxPrime=0;
        int n=nums.length;
        
        for (int i=0;i<n;i++) {
            int val1=nums[i][i];
            if (val1>maxPrime && isPrime(val1)) {
                maxPrime=val1;
            }
            int val2=nums[i][n - 1 - i];
            if (val2>maxPrime && isPrime(val2)) {
                maxPrime=val2;
            }
        }
        
        return maxPrime;
    }
}