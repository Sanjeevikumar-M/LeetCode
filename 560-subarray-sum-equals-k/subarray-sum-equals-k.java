class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> subsum = new HashMap<>();
        subsum.put(0,1);
        int total = 0;
        int count = 0;
        for(int n:nums){
            total += n;
            count += subsum.getOrDefault(total-k,0);
            subsum.put(total,subsum.getOrDefault(total,0)+1);
        }
        return count;
    }
}