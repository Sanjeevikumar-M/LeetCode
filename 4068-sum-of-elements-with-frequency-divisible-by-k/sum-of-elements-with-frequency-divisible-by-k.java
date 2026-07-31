class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        int ar[] = new int[101];
        for(int val:nums) {
            ar[val]++;
        }
        int res=0;
        for(int i=1;i<ar.length;i++) {
            if(ar[i]!=0 && ar[i]%k==0) {
                res = res + ar[i]*i;
            }
        }
        return res;
    }
}