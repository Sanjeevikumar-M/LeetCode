class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int r=0;r<n;r++){
            while(!stack.isEmpty() && temperatures[r]>temperatures[stack.peek()]){
                int previdx = stack.pop();
                res[previdx] = r-previdx;
            }
            stack.push(r);
        }
        return res;
    }
}