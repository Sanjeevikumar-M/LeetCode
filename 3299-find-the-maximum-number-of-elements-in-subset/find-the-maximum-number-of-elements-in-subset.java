import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put((long) num, countMap.getOrDefault((long) num, 0) + 1);
        }

        int maxLength = 0;

        if (countMap.containsKey(1L)) {
            int oneCount = countMap.get(1L);
            maxLength = (oneCount % 2 == 0) ? oneCount - 1 : oneCount;
        }

        for (long x : countMap.keySet()) {
            if (x == 1) continue;

            int currentLength = 0;
            long current = x;

            while (countMap.containsKey(current) && countMap.get(current) >= 2) {
                currentLength += 2;
                current = current * current; 
            }

            if (countMap.containsKey(current) && countMap.get(current) >= 1) {
                currentLength += 1;
            } else {
                currentLength -= 1; 
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}