import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Step 1: Store indices
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int ans = Integer.MAX_VALUE;
        
        // Step 2: Process each group
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue;
            
            for (int i = 0; i <= list.size() - 3; i++) {
                int p = list.get(i);
                int r = list.get(i + 2);
                
                ans = Math.min(ans, r - p);
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans * 2;
    }
}