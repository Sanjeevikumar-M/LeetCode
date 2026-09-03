class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while(top<=bottom && left<=right){
            for(int row=left;row<=right;row++){
                result.add(matrix[top][row]);
            }
            top++;

            for(int col=top;col<=bottom;col++){
                result.add(matrix[col][right]);
            }
            right--;

            if(top<=bottom){
                for(int row=right;row>=left;row--){
                    result.add(matrix[bottom][row]);
                }
                bottom--;
            }

            if(left<=right){
                for(int col=bottom;col>=top;col--){
                    result.add(matrix[col][left]);
                }
                left++;
            }
        }

        return result;
    }
}