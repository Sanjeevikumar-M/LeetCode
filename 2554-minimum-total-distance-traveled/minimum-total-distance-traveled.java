import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        int n = robot.size();
        int m = factory.length;

        Long[][] dp = new Long[n + 1][m + 1];

        return solve(0, 0, robot, factory, dp);
    }

    private long solve(int i, int j, List<Integer> robot, int[][] factory, Long[][] dp) {
        // all robots repaired
        if (i == robot.size()) return 0;

        // no factories left but robots remain
        if (j == factory.length) return Long.MAX_VALUE / 2;

        if (dp[i][j] != null) return dp[i][j];

        long res = solve(i, j + 1, robot, factory, dp); // skip this factory

        long cost = 0;
        int factoryPos = factory[j][0];
        int limit = factory[j][1];

        // assign k robots to this factory
        for (int k = 0; k < limit && i + k < robot.size(); k++) {
            cost += Math.abs(robot.get(i + k) - factoryPos);
            res = Math.min(res, cost + solve(i + k + 1, j + 1, robot, factory, dp));
        }

        return dp[i][j] = res;
    }
}