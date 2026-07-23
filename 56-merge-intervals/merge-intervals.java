class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> res = new ArrayList<>();
        int[] currentInterval = intervals[0];
        res.add(currentInterval);
        for(int i=0;i<intervals.length;i++){
            int[] newInterval = intervals[i];

            if(newInterval[0]<=currentInterval[1]){
                currentInterval[1] = Math.max(currentInterval[1],newInterval[1]);
            }else{
                currentInterval = newInterval;
                res.add(currentInterval);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}