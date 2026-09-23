class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1count = new int[26];
        int[] s2count = new int[26];

        for(int i=0;i<s1.length();i++){
            s1count[s1.charAt(i)-'a']++;
            s2count[s2.charAt(i)-'a']++;
        }

        for(int i=0;i<s2.length() - s1.length();i++){
            if(match(s1count,s2count)) return true;

            s2count[s2.charAt(i)-'a']--;
            s2count[s2.charAt(s1.length()+i)-'a']++;
        } 

        return match(s1count,s2count);
    }

    private static boolean match(int[] s1, int[] s2){
        for(int i=0;i<26;i++){
            if(s1[i]!=s2[i]) return false;
        }
        return true;
    } 
}