class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int i:nums){
            if(i%2==0){
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }
        int min = -1;
        int max = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
                min = entry.getKey();
            }else if(entry.getValue() == max){
                min = Math.min(min,entry.getKey());
            }
        }
        return min;
    }
}