class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i+1<nums.length;i+=2){
            int freq = nums[i];
            int val = nums[i+1];
            for(int j=0;j<freq;j++){
                res.add(val);
            }
        }
        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}