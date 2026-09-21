class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }

        List<Integer> res = new ArrayList<>(map.keySet());

        res.sort((w1,w2) -> {
            int count1 = map.get(w1);
            int count2 = map.get(w2);
            if(count1!=count2){
                return Integer.compare(count2,count1);
            }
            return w1.compareTo(w2);
        });

        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
}