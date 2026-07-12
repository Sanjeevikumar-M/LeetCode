import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // 1. Clone the original array to preserve the order, then sort the clone
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        // 2. Map each unique element to its rank starting from 1
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : sortedArr) {
            // Only assign a rank if the element hasn't been ranked yet (handles duplicates)
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }
        
        // 3. Replace each element in the original array with its rank
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        
        return arr;
    }
}