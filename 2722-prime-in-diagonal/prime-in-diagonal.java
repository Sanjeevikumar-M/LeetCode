class Solution {
    private static boolean isPrime(int num){
        if(num==1) return false;
        for(int i=2;i*i<=num;i++){
            if(num%i == 0) return false;
        }
        return true;
    }

    public int diagonalPrime(int[][] nums) {
        int max = 0;
        int lrow = 0;
        int lcol = 0;
        int rcol = nums[0].length - 1;
        while(lrow < nums.length){
            boolean lprime = isPrime(nums[lrow][lcol]);
            boolean rprime = isPrime(nums[lrow][rcol]);
            if(lprime){
                max = nums[lrow][lcol] > max ? nums[lrow][lcol] : max;
            }
            if(rprime){
                max = nums[lrow][rcol] > max ? nums[lrow][rcol] : max;
            }
            lrow++;
            lcol++;
            rcol--;
        }
        return max;
    }
}