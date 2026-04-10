import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Step 1: Store indices for each number
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        
        int minDist = Integer.MAX_VALUE;
        
        // Step 2: Process each group
        for (List<Integer> list : map.values()) {
            int size = list.size();
            if (size < 3) continue;
            
            // Step 3: Try all triplets
            for (int i = 0; i < size - 2; i++) {
                for (int j = i + 1; j < size - 1; j++) {
                    for (int k = j + 1; k < size; k++) {
                        int dist = 2 * (list.get(k) - list.get(i));
                        minDist = Math.min(minDist, dist);
                    }
                }
            }
        }
        
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}