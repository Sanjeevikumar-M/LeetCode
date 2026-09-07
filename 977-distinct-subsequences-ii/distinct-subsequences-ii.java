class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;

        int tot = 0;
        int[] dp = new int[26];
        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i)-97;
            int add = (tot-dp[ch]+MOD)%MOD;

            dp[ch] = tot+1;
            tot = (dp[ch]+add)%MOD;
        }
        return tot;
    }
}