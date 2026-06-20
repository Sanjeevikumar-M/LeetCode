import java.util.Arrays;
import java.util.List;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        // 1. Create a new array to accommodate the 2 extra boundary restrictions
        int[][] res = new int[restrictions.length + 2][2];
        
        // Copy existing restrictions
        for (int i = 0; i < restrictions.length; i++) {
            res[i][0] = restrictions[i][0];
            res[i][1] = restrictions[i][1];
        }
        
        // Add boundaries: Building 1 (height 0) and Building n (max possible height n - 1)
        res[restrictions.length] = new int[]{1, 0};
        res[restrictions.length + 1] = new int[]{n, n - 1};
        
        // 2. Sort restrictions by building ID (index 0)
        Arrays.sort(res, (a, b) -> Integer.compare(a[0], b[0]));
        
        int m = res.length;
        
        // 3. Forward Pass: Left to Right propagation
        for (int i = 0; i < m - 1; i++) {
            int x1 = res[i][0], h1 = res[i][1];
            int x2 = res[i + 1][0], h2 = res[i + 1][1];
            res[i + 1][1] = Math.min(h2, h1 + (x2 - x1));
        }
        
        // 4. Backward Pass: Right to Left propagation
        for (int i = m - 1; i > 0; i--) {
            int x1 = res[i][0], h1 = res[i][1];
            int x2 = res[i - 1][0], h2 = res[i - 1][1];
            res[i - 1][1] = Math.min(h2, h1 + (x1 - x2));
        }
        
        // 5. Calculate the absolute max height between any two restriction boundaries
        int maxHeight = 0;
        for (int i = 0; i < m - 1; i++) {
            int x1 = res[i][0], h1 = res[i][1];
            int x2 = res[i + 1][0], h2 = res[i + 1][1];
            
            // Peak formula to find the tallest building possible between x1 and x2
            // Using long arithmetic inside the formula avoids integer overflow for large coordinates
            int peak = (int) (((long) h1 + h2 + (x2 - x1)) / 2);
            maxHeight = Math.max(maxHeight, peak);
        }
        
        return maxHeight;
    }
}