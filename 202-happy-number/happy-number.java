class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNumber(n);
        while(fast != 1 && slow != fast){
            slow = getNumber(slow);
            fast = getNumber(getNumber(fast));
        }
        return fast==1;
    }

    private int getNumber(int n){
        int sum = 0;
        while(n>0){
            int rem = n%10;
            sum += rem*rem;
            n/=10;
        }
        return sum;
    }
}