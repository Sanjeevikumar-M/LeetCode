class Solution {
    public int smallestValue(int n) {
        while(true){
            int temp = n, sum=0, i=2;
            while(i*i<=temp){
                while(temp%i == 0){
                    temp /= i;
                    sum += i;
                }
                i++;
            }
            if(temp > 1) sum+=temp;
            if(sum == n) return sum;
            n = sum;
        }
    }
}