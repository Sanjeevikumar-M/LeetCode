class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;

        int row = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int max = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j] == '1'){
                    heights[j] += 1;
                }
                else{
                    heights[j] = 0;
                }
            }
            max = Math.max(max, largestRectangle(heights));
        }

        return max;
    }

    public static int largestRectangle(int[] heights){
        Deque<Integer> stack = new ArrayDeque<>();
        int rect = 0;

        for(int i=0; i<=heights.length; i++){
            int current = (i == heights.length) ? 0 : heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] > current){
                int height = heights[stack.pop()];
                int width = (stack.isEmpty()) ? i : i - stack.peek() -1;

                rect = Math.max(rect, height*width);
            }

            stack.push(i);
        }

        return rect;
    }
}