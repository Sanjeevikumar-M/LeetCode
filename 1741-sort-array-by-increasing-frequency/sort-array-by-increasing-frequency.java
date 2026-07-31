class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int j = 0;
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
            list.add(i);
        }

        Collections.sort(list,(a,b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);

            if(freqA!=freqB){
                return freqB-freqA;
            }
            return a-b;
        });

        int m = 0;
        for(int i=list.size()-1;i>=0;i--){
            nums[m] = list.get(i);
            m++;
        }

        return nums;
    }
}