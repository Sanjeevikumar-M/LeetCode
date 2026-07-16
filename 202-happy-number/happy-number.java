class Solution {
    public boolean isHappy(int n) {
        while(n!=1 && n!=4){
            int totalSum = 0;
            while(n>0){
                int rem = n%10;
                totalSum += rem*rem;
                n/=10;
            }
            n = totalSum;
        }
        return n==1;
    }
}