class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int i = 0;
        for(String s:arr){
            if(map.get(s)==1){
                i+=1;
                if(i==k){
                    return s;
                }
            }
        }
        return "";
    }
}