class Solution {
    // Fenwick Tree (Binary Indexed Tree) implementation
    private void update(int[] bit, int index, int delta) {
        while (index < bit.length) {
            bit[index] += delta;
            index += index & (-index);
        }
    }

    private int query(int[] bit, int index) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }
        return sum;
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        
        // The prefix sum can range from -n to n. 
        // We shift everything by + (n + 1) to keep indices positive for the BIT.
        int offset = n + 1;
        int maxVal = 2 * n + 2;
        int[] bit = new int[maxVal];
        
        long totalSubarrays = 0;
        int currentPrefSum = 0;
        
        // Insert the initial prefix sum (pref[0] = 0) into the BIT
        update(bit, 0 + offset, 1);
        
        for (int num : nums) {
            // Step 1: Update current prefix sum (+1 if match, -1 if mismatch)
            if (num == target) {
                currentPrefSum += 1;
            } else {
                currentPrefSum -= 1;
            }
            
            // Step 2: Query the BIT to count how many previous prefix sums are strictly smaller
            // currentPrefSum + offset - 1 gives us the upper bound for strictly smaller elements
            totalSubarrays += query(bit, currentPrefSum + offset - 1);
            
            // Step 3: Add the current prefix sum to the BIT
            update(bit, currentPrefSum + offset, 1);
        }
        
        return totalSubarrays;
    }
}