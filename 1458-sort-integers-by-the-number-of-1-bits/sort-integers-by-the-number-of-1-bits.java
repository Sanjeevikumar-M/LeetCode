import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        
        Integer[] nums = new Integer[arr.length];
        
        // Convert int[] → Integer[]
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (a, b) -> {
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);

            if (bitA == bitB) {
                return a - b;      // secondary sorting
            }
            return bitA - bitB;    // primary sorting
        });

        // Convert back to int[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }

        return arr;
    }
}