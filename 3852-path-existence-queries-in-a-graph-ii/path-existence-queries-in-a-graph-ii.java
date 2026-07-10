import java.util.Arrays;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Pair up values with their original indices
        int[][] elements = new int[n][2];
        for (int i = 0; i < n; i++) {
            elements[i][0] = nums[i];
            elements[i][1] = i;
        }
        
        // Sort based on the actual values in nums
        Arrays.sort(elements, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Map original index to sorted position index
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[elements[i][1]] = i;
        }
        
        // Compute the greedy next pointer for each sorted element
        // nextP[i] stores the index of the furthest element to the right reachable from i
        int[] nextP = new int[n];
        int right = 0;
        for (int i = 0; i < n; i++) {
            while (right < n && elements[right][0] - elements[i][0] <= maxDiff) {
                right++;
            }
            nextP[i] = right - 1; 
        }
        
        // Build the Binary Lifting Table (Sparse Table)
        int LOG = 18; // 2^17 = 131,072 > 10^5
        int[][] up = new int[n][LOG];
        
        for (int i = 0; i < n; i++) {
            up[i][0] = nextP[i];
        }
        
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }
        
        int[] answer = new int[queries.length];
        
        for (int q = 0; q < queries.length; q++) {
            int u = queries[q][0];
            int v = queries[q][1];
            
            if (u == v) {
                answer[q] = 0;
                continue;
            }
            
            int pU = pos[u];
            int pV = pos[v];
            
            // Ensure pU is the smaller value to lift towards pV
            if (pU > pV) {
                int temp = pU;
                pU = pV;
                pV = temp;
            }
            
            // If the maximum reach of pU cannot even cross or equal pV, they are disconnected
            if (up[pU][LOG - 1] < pV) {
                answer[q] = -1;
                continue;
            }
            
            // Binary lift to count the minimum required steps
            int steps = 0;
            int curr = pU;
            
            for (int j = LOG - 1; j >= 0; j--) {
                if (up[curr][j] < pV) {
                    curr = up[curr][j];
                    steps += (1 << j);
                }
            }
            
            // One final jump from the lower bound to cover or overshoot pV safely
            steps += 1;
            answer[q] = steps;
        }
        
        return answer;
    }
}