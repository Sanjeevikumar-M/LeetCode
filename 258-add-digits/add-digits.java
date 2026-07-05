class Solution {
    public int addDigits(int num) {
        int r = result(num);
        while(r > 9){
            r = result(r);
        }
        return r;
    }

    private static int result(int n){
        int res = 0;
        while(n>0){
            int rem = n%10;
            res += rem;
            n/=10;
        }
        return res;
    }
}