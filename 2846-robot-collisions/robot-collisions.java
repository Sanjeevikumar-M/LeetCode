class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++)
            indices[i] = i;

        Arrays.sort(indices, (a, b) -> positions[a] - positions[b]);

        int[] st = new int[n];
        int top = -1;

        for (int idx : indices) {
            if (directions.charAt(idx) == 'R') {
                st[++top] = idx; // push right-moving robot
            } else {
                while (top >= 0 && healths[idx] > 0) {
                    int rightRobot = st[top]; // peek top
                    if (healths[rightRobot] < healths[idx]) {
                        healths[rightRobot] = 0;
                        healths[idx]--;
                        top--; // pop
                    } else if (healths[rightRobot] > healths[idx]) {
                        healths[idx] = 0;
                        healths[rightRobot]--;
                    } else {
                        healths[rightRobot] = 0;
                        healths[idx] = 0;
                        top--; // pop
                    }
                }
            }
        }

        // Collect survivors from healths array
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0)
                result.add(healths[i]);
        }
        return result;
    }
}