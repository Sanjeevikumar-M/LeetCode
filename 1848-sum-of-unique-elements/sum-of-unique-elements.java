class Solution {
    public int sumOfUnique(int[] nums) {
        int sum = 0;
        int[] res = new int[101];
        for(int i:nums){
            res[i]++;
        }
        for(int i:nums){
            if(res[i]==1){
                sum += i;
            }
        }
        return sum;
    }
}