import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        
        Deque<Integer> stack = new ArrayDeque<>();
        int num_k = Integer.MIN_VALUE; // Represents the '2' in the 132 pattern

        // Traverse from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            // If we find an element smaller than our '2', we found the '1' (132 pattern complete)
            if (nums[i] < num_k) {
                return true;
            }
            
            // If the current element is larger than the stack top, 
            // it can serve as a better '3' (middle). Pop the stack to update '2'.
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                num_k = stack.pop();
            }
            
            // Push the current element as a potential '2' candidate for elements further left
            stack.push(nums[i]);
        }
        
        return false;
    }
}