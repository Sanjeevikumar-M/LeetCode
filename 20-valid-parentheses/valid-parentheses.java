class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n%2 != 0) return false;
        char[] ch = new char[n];
        int idx = 0;
        for(char c:s.toCharArray()){
            if(c=='('){
                ch[idx++] = ')';
            }else if(c=='{'){
                ch[idx++] = '}';
            }else if(c=='['){
                ch[idx++] = ']';
            }else if(idx == 0 || ch[--idx]!=c){
                return false;
            }
        }
        return idx==0;
    }
}