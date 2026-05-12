class Solution {
    public int minimumEffort(int[][] tasks) {
        // Sort by (minimum - actual) descending
        // Tasks with larger buffer go first
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int required = 0;
        // Scan right-to-left to accumulate minimum initial energy
        for (int i = tasks.length - 1; i >= 0; i--) {
            int actual  = tasks[i][0];
            int minimum = tasks[i][1];
            // Either we need enough to meet this task's threshold,
            // or enough to cover this task + all subsequent ones
            required = Math.max(required + actual, minimum);
        }

        return required;
    }
}