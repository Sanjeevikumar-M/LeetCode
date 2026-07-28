import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length<3) return false;

        Deque<Integer> stack = new ArrayDeque<>();
        int num_k = Integer.MIN_VALUE;

        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<num_k) return true;

            while(!stack.isEmpty() && nums[i]>stack.peek()){
                num_k = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}