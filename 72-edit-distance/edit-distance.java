class Solution {
    static int[][] memo;

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        memo = new int[m][n];

        for(int[] rows:memo){
            Arrays.fill(rows,-1);
        }

        return solve(0,0,word1,word2);
    }

    private static int solve(int i,int j,String word1,String word2){
        if(i==word1.length()) return word2.length() - j;
        if(j==word2.length()) return word1.length() - i;

        if(memo[i][j]!=-1){
            return memo[i][j];
        }

        if(word1.charAt(i)==word2.charAt(j)){
            return memo[i][j] = solve(i+1,j+1,word1,word2);
        }

        return memo[i][j] = 1 + Math.min(solve(i+1,j,word1,word2),Math.min(solve(i,j+1,word1,word2),solve(i+1,j+1,word1,word2)));
    }
}