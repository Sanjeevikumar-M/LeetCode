class Solution {
    public int minimumPushes(String word) {
        int d = word.length() / 8;
        int m = word.length() % 8;
        return 4 * d * (d + 1) + m * (d + 1);
    }
}