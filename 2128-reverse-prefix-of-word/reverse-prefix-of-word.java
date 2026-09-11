class Solution {
    public String reversePrefix(String word, char ch) {
        int r = word.indexOf(ch);
        if(r==-1){
            return word;
        }
        int l = 0;
        char[] c = word.toCharArray();
        while(l<r){
            char t = c[l];
            c[l] = c[r];
            c[r] = t;
            l++;
            r--;
        } 
        return new String(c);
    }
}