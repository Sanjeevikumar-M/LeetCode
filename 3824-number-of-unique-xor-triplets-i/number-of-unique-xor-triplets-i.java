class Solution {
    public int uniqueXorTriplets(int[] nums) {
        // int n = nums.length;

        // if(n==1) return 1;
        // if(n==2) return 2;

        // return Integer.highestOneBit(n)*2;
        int n = nums.length;
        if(n < 3) return n;
        int nearest = (int)(Math.log(n)/Math.log(2));
        return 1 << (nearest + 1);
    }
}