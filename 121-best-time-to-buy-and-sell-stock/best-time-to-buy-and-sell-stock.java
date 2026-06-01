class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int x:prices){
            min = Math.min(x,min);
            int n = x-min;
            max = Math.max(n,max);
        }
        return max;
    }
}