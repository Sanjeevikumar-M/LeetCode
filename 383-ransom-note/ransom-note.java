class Solution {
    public boolean canConstruct(String ransomNote, String mag) {
        if(ransomNote.length() > mag.length()) return false;
        
        int[] indexes = new int[26];
        for(char c : ransomNote.toCharArray()) {
            int index = mag.indexOf(c, indexes[c - 'a']);

            if(index == -1) return false;

            indexes[c - 'a'] = index + 1;
        }
        return true;
    }
}