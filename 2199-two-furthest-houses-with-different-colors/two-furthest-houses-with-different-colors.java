class Solution {
    public int maxDistance(int[] colors) {
        int maxdist = Integer.MIN_VALUE;
        for(int i=0;i<colors.length - 1;i++){
            for(int j=i+1;j<colors.length;j++){
                if(colors[i]!=colors[j]){
                    maxdist = Math.max(maxdist, Math.abs(i-j));
                }
            }
        }
        return maxdist;
    }
}