class Solution {
    public boolean squareIsWhite(String coordinates) {
        int n = coordinates.charAt(0) - 'a' + 1;
        int m = coordinates.charAt(1) - '0';
        return (m+n)%2!=0;
    }
}