class Solution {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        for(char ch: words[0].toCharArray()){
            count[ch-'a']++;
        }
        for(int i=1;i<words.length;i++){
            String word = words[i];
            int[] freq = new int[26];
            for(char ch:word.toCharArray()){
                freq[ch-'a']++;
            }
            for(int j=0;j<26;j++){
                count[j] = Math.min(count[j],freq[j]);
            }
        }
        List<String> res = new ArrayList<>();
        String s = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0;i<26;i++){
            if(count[i]!=0){
                while(count[i]-->0){
                    res.add(String.valueOf(s.charAt(i)));
                }
            }
        }
        return res;
    }
}