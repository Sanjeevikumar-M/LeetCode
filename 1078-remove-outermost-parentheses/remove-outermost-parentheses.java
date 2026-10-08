class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        if(n<=2) return "";
        int open = 1;
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<n;i++){
            if(ch[i]=='('){
                open++;
                if(open>1) sb.append(ch[i]);
            }else{
                if(open>1) sb.append(ch[i]);
                open--;
            }
        }
        return sb.toString();
    }
}