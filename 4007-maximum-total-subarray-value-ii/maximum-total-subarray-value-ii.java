import java.util.PriorityQueue;

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        
        // 1. Determine log values for Sparse Table dimensions
        int maxLog = 31 - Integer.numberOfLeadingZeros(n);
        int[][] stMax = new int[maxLog + 1][n];
        int[][] stMin = new int[maxLog + 1][n];
        
        // Base layer initialization
        for (int j = 0; j < n; j++) {
            stMax[0][j] = nums[j];
            stMin[0][j] = nums[j];
        }
        
        // Populate Sparse Table
        for (int i = 1; i <= maxLog; i++) {
            for (int j = 0; j + (1 << i) <= n; j++) {
                stMax[i][j] = Math.max(stMax[i - 1][j], stMax[i - 1][j + (1 << (i - 1))]);
                stMin[i][j] = Math.min(stMin[i - 1][j], stMin[i - 1][j + (1 << (i - 1))]);
            }
        }
        
        // Helper Lambda or function to query the range value in O(1)
        java.util.function.BiFunction<Integer, Integer, Long> queryValue = (l, r) -> {
            int len = r - l + 1;
            int i = 31 - Integer.numberOfLeadingZeros(len);
            int mx = Math.max(stMax[i][l], stMax[i][r - (1 << i) + 1]);
            int mn = Math.min(stMin[i][l], stMin[i][r - (1 << i) + 1]);
            return (long) mx - mn;
        };
        
        // 2. Max-Heap configuration
        // Object format: [subarray_value, left_bound, right_bound]
        PriorityQueue<long[]> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        
        // Initialize the heap with the largest candidate for each 'l'
        for (int l = 0; l < n; l++) {
            long val = queryValue.apply(l, n - 1);
            maxHeap.offer(new long[]{val, l, n - 1});
        }
        
        long totalValue = 0;
        
        // 3. Extract top k distinct elements
        for (int step = 0; step < k; step++) {
            if (maxHeap.isEmpty()) {
                break;
            }
            
            long[] current = maxHeap.poll();
            long val = current[0];
            int l = (int) current[1];
            int r = (int) current[2];
            
            totalValue += val;
            
            // If there's a smaller valid range inside this sequence, push it
            if (r > l) {
                long nextVal = queryValue.apply(l, r - 1);
                maxHeap.offer(new long[]{nextVal, l, r - 1});
            }
        }
        
        return totalValue;
    }
}