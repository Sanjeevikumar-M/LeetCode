class Solution {
    public String[] createGrid(int m, int n) {
        String[][] ans = new String[m][n];
        for(String[] i:ans){
            Arrays.fill(i,"#");
        }
        int t = 0;
        while(t<n){
            ans[0][t++] = ".";
        }
        int l = 0;
        while(l<m){
            ans[l++][n-1] = ".";
        }
        String[] res = new String[m];
        int idx = 0;
        for(String[] i:ans){
            res[idx++] = String.join("",i);
        }
        return res;
    }
}