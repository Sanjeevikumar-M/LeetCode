import java.util.*;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length; 
        int ans = n; 

        // Map: key = reverse(nums[i]), value = index i (latest index)
        Map<Integer, Integer> lastIndex = new HashMap<>(n, 1.0f);

        for (int j = 0; j < n; j++) {

            // Check if current number matches any previously stored reversed value
            int x = nums[j];
            Integer i = lastIndex.get(x); 

            if (i != null) {  
                int dist = j - i;  
                ans = Math.min(ans, dist);  
            }

            // Compute reverse of current number
            int t = x;
            int rev = 0;

            while (t > 0) {  
                int digit = t % 10;  
                rev = rev * 10 + digit;  
                t = t / 10;  
            }

            // Store reversed number with current index
            lastIndex.put(rev, j);
        }

        // Return result
        return (ans < n) ? ans : -1;
    }
}