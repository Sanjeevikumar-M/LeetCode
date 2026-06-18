class Solution {
    public String toLowerCase(String s) {
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            int as = (int) s.charAt(i);
            if(as >= 65 && as <= 90){
                char ch = (char) (as+32);
                str.append(ch);
            }else{
                str.append((char) as);
            }
        }
        return str.toString();
    }
}