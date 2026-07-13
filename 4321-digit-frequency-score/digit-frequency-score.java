class Solution {
    public int digitFrequencyScore(int n) {
        String s = String.valueOf(n);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(char i:s.toCharArray()){
            int d = i - '0';
            map.put(d,map.getOrDefault(d,0)+1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += (entry.getKey()*entry.getValue());
        }

        return sum;
    }
}