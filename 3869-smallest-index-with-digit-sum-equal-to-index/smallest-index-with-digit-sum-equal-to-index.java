class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==digitsum(nums[i])){
                return i;
            }
        }
        return -1;
    }

    private static int digitsum(int num){
        if(num<10){
            return num;
        }
        int sum = 0;
        while(num>0){
            int rem = num%10;
            sum+=rem;
            num/=10;
        }
        return sum;
    }
}