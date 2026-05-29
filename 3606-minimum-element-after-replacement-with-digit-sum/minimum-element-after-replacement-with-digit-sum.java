class Solution {
    public int minElement(int[] nums) {
        int[] sum = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int s = 0;
            int n = nums[i];
            while(n>0){
                int rem = n%10;
                s += rem;
                n = n/10;
            }
            sum[i] = s;
        }
        int min = Integer.MAX_VALUE;
        for(int i:sum){
            min = Math.min(min,i);
        }
        return min;
    }
}