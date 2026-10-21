class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        int n = rowIndex;
        long val = 1;

        for(int r=0; r<=n; r++){
            result.add((int)val);
            val = val*(n-r)/(r+1);
        }

        return result;
    }
}