class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        int n = nums.size();
        for(int i=0;i<n;i++){
            int count = 0;
            boolean[] seen = new boolean[101];
            for(int j=i;j<n;j++){
                if(!seen[nums.get(j)]){
                    seen[nums.get(j)] = true;
                    count++;
                }
                ans+=count*count;
            }
        }
        return ans;
    }
}