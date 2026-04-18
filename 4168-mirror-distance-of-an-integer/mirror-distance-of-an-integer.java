class Solution {
    public int mirrorDistance(int n) {
        String s = new StringBuilder(String.valueOf(n)).reverse().toString();
        int num = Integer.parseInt(s); 
        return Math.abs(n-num);
    }
}