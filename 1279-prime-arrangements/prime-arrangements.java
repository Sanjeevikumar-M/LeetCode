class Solution {
    public int numPrimeArrangements(int n) {
        int MOD = 1_000_000_007;
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime,true);
        prime[0] = prime[1] = false;
        for(int i=2;i*i<=n;i++){
            if(prime[i]){
                for(int p=i*i;p<=n;p+=i){
                    prime[p] = false;
                }
            }
        }
        int count = 0;
        for(int i=2;i<=n;i++){
            if(prime[i]) count++;
        }

        long ans = 1;
        for(int i=1;i<=count;i++){
            ans = (ans*i) % MOD;
        }
        for(int i=1;i<=n-count;i++){
            ans = (ans*i) % MOD;
        }

        return (int) ans;
    }
}