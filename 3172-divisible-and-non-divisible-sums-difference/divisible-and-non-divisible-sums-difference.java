class Solution {
    public int differenceOfSums(int n, int m) {
        return ((n*(n+1))/2)-(((((n-(n%m))/m) * (((n-(n%m))/m)+1))/2)*m*2);
    }
}