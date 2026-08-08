class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        int[] count = new int[26];
        for(char i:magazine.toCharArray()){
            count[i-'a']++;
        }
        for(char i:ransomNote.toCharArray()){
            if(count[i-'a'] == 0) return false;
            count[i-'a']--;
        }
        return true;
    }
}