class Solution {
    public long removeZeros(long n) {
        long ans = 0;
        long count = 1;
        while( n > 0 )
            {
                long digit = n % 10;
                if(digit != 0)
                {
                    ans += (digit * count);
                    count *= 10;
                }
                n /= 10;
            }
        return ans;
    }
}