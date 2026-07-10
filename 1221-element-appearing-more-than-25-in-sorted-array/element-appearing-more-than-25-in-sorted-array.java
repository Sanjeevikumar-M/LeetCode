class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length / 4;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:map.keySet()){
            if(map.get(i)>n){
                return i;
            }
        }
        return -1;
    }
}