class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            if (Character.isLetterOrDigit(s.charAt(i))){
                str.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        String original = str.toString();
        String reversed = str.reverse().toString();
        return original.equals(reversed);
    }
}