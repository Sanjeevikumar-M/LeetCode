class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for(char i:s.toCharArray()){
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

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }

        return sb.toString();
    }
}