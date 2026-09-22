class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        boolean result = false;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    result = backtrack(board,visited,word,m,n,i,j,0);
                    if(result) return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, boolean[][] visited, String word, int m, int n, int i, int j, int index){
        if(index >= word.length()){
            return true;
        }

        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }

        visited[i][j] = true;

        if(backtrack(board,visited,word,m,n,i+1,j,index+1) ||
           backtrack(board,visited,word,m,n,i-1,j,index+1) ||
           backtrack(board,visited,word,m,n,i,j-1,index+1) ||
           backtrack(board,visited,word,m,n,i,j+1,index+1) 
        ){
            return true;
        }

        visited[i][j] = false;

        return false;
    }
}