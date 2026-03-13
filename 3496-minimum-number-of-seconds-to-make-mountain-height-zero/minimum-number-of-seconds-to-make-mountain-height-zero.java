class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 0;
        long right = (long) 1e18;
        long ans = right;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (canReduce(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canReduce(long time, int height, int[] workerTimes) {

        long reduced = 0;

        for (int t : workerTimes) {

            double val = (double)time / t;
            long x = (long)((Math.sqrt(1 + 8 * val) - 1) / 2);

            reduced += x;

            if (reduced >= height)
                return true;
        }

        return false;
    }
}