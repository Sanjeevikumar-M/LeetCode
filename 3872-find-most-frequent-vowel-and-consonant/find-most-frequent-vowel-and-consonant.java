class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char i:s.toCharArray()){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int vmax = 0;
        int cmax = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char ch = entry.getKey();
            int freq = entry.getValue();
            if(isVowel(ch)){
                vmax = Math.max(vmax,freq);
            }else{
                cmax = Math.max(cmax,freq);
            }
        }
        return vmax+cmax;
    }

    private boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}