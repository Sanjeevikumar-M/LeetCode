class Solution {
    public int sumFourDivisors(int[] nums) {
        int sumOfDigi = 0;
        for(int i=0;i<nums.length;i++){
            sumOfDigi += fourDivSum(nums[i]); 
        }
        return sumOfDigi;
    }

    private static int fourDivSum(int n){
        int sum = 0;
        int count = 0;
        for(int i=1;i<=n;i++){
            if(n%i == 0){
                count++;
                sum += i;
            }
            if(count>4){
                return 0;
            }
        }

        return count==4 ? sum : 0;
    }
}