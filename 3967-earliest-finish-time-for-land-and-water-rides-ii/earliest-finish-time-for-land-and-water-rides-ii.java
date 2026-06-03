import java.util.*;

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long ans = Math.min(
                solve(landStartTime, landDuration, waterStartTime, waterDuration),
                solve(waterStartTime, waterDuration, landStartTime, landDuration)
        );

        return (int) ans;
    }

    private long solve(int[] start1, int[] dur1,
                       int[] start2, int[] dur2) {

        int m = start2.length;

        int[][] rides = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides[i][0] = start2[i];
            rides[i][1] = dur2[i];
        }

        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

        int[] starts = new int[m];
        long[] prefixMinDur = new long[m];
        long[] suffixMinFinish = new long[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        prefixMinDur[0] = rides[0][1];
        for (int i = 1; i < m; i++) {
            prefixMinDur[i] = Math.min(prefixMinDur[i - 1], rides[i][1]);
        }

        suffixMinFinish[m - 1] = (long) rides[m - 1][0] + rides[m - 1][1];
        for (int i = m - 2; i >= 0; i--) {
            suffixMinFinish[i] = Math.min(
                    suffixMinFinish[i + 1],
                    (long) rides[i][0] + rides[i][1]
            );
        }

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < start1.length; i++) {
            long finishFirst = (long) start1[i] + dur1[i];

            int idx = upperBound(starts, (int) finishFirst);

            if (idx > 0) {
                ans = Math.min(ans, finishFirst + prefixMinDur[idx - 1]);
            }

            if (idx < m) {
                ans = Math.min(ans, suffixMinFinish[idx]);
            }
        }

        return ans;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}