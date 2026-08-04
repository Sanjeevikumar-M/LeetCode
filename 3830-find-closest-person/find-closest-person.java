class Solution {
    public int findClosest(int x, int y, int z) {
        int m = Math.abs(x-z);
        int n = Math.abs(y-z);
        if(m-n == 0){
            return 0;
        }
        return m>n ? 2 : 1;
    }
}