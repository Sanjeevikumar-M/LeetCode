class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        
        List<int[]> res = new ArrayList<>();
        int[] currIntervel = intervals[0];
        res.add(currIntervel);

        for(int i=1;i<intervals.length;i++){
            int[] nextInterval = intervals[i];

            if(nextInterval[0] <= currIntervel[1]){
                currIntervel[1] = Math.max(currIntervel[1],nextInterval[1]);
            }else{
                currIntervel = nextInterval;
                res.add(currIntervel);
            }
        }

        return res.toArray(new int[res.size()][2]);
    }
}