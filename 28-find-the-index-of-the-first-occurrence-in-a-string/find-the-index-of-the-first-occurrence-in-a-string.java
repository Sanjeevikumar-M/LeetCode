class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.indexOf(needle);
        return m==-1 ? -1:m;
    }
}