class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int[] stack = new int[n];
        int top = -1;
        for(int r=0;r<n;r++){
            while(top>=0 && temperatures[r]>temperatures[stack[top]]){
                int previdx = stack[top--];
                res[previdx] = r-previdx;
            }
            stack[++top] = r;
        }
        return res;
    }
}