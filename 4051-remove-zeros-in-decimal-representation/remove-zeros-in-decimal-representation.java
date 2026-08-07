class Solution {
    public long removeZeros(long n) {
        long res = 0;
        while(n>0){
            long rem = n%10;
            if(rem==0){
                n/=10;
                continue;
            }
            res = res*10 + rem;
            n/=10;
        }
        long temp = 0;
        while(res>0){
            long rem = res%10;
            temp = temp*10 + rem;
            res/=10;
        }
        return temp;
    }
}