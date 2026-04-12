class Solution {

    public int minimumDistance(String word) {
        int n = word.length();

        // dp[i][j] = min cost where fingers are at i and j
        int[][] dp = new int[27][27];

        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[26][26] = 0; // 26 means no finger placed yet

        for (char ch : word.toCharArray()) {
            int cur = ch - 'A';
            int[][] newDp = new int[27][27];

            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {
                    newDp[i][j] = Integer.MAX_VALUE;
                }
            }

            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {
                    if (dp[i][j] == Integer.MAX_VALUE) continue;

                    // Move finger1 to cur
                    int cost1 = dp[i][j] + dist(i, cur);
                    newDp[cur][j] = Math.min(newDp[cur][j], cost1);

                    // Move finger2 to cur
                    int cost2 = dp[i][j] + dist(j, cur);
                    newDp[i][cur] = Math.min(newDp[i][cur], cost2);
                }
            }

            dp = newDp;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                ans = Math.min(ans, dp[i][j]);
            }
        }

        return ans;
    }

    private int dist(int a, int b) {
        if (a == 26) return 0;

        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}