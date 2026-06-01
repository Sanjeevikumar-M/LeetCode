class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = grid.length;
        int total = n*n;
        int repeted = 0;
        int missing = 0;

        for(int[] row:grid){
            for(int i:row){
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }

        for(int i=0;i<=total;i++){
            if(map.containsKey(i)){
                if(map.get(i)==2){
                    repeted = i;
                }
            }
            else{
                missing = i;
            }
        }
        return new int[]{repeted,missing};
    }
}