class Solution {
    public String reverseStr(String s, int k) {
        if(s.length() == k){
            return new StringBuilder(s).reverse().toString();
        }
        String revstr = "";
        int i = 0;
        int n = s.length();
        while(i<s.length()){
            int endfirst = Math.min(i+k,n);
            int endsec = Math.min(i+k*2,n);
            revstr += new StringBuilder(s.substring(i,endfirst)).reverse().toString() + s.substring(endfirst,endsec);
            i = i+2*k;
        }
        return revstr;
    }
}