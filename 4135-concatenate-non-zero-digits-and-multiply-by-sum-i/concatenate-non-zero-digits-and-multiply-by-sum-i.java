class Solution {
    public long sumAndMultiply(int n) {
        if(n==0) return 0;

        long x = 0;
        long sum = 0;
        long placeholder = 1;

        while(n>0){
            long rem = n%10;
            if(rem!=0){
                x += rem*placeholder;
                sum += rem; 
                placeholder *= 10;
            }
            n/=10;
            
        }
        return sum*x;
    }
}