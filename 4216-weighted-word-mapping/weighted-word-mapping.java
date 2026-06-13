class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<words.length;i++){
            String s = words[i];
            int sum = 0;
            for(int j=0;j<s.length();j++){
                char ch = s.charAt(j);
                sum += weights[ch-'a'];
            }
            int m = sum%26;
            char mappedChar = (char) ('z'-m);
            str.append(mappedChar);
        }
        return str.toString();
    }
}