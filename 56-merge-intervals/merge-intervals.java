class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> res = new ArrayList<>();
        int[] current = intervals[0];
        res.add(current);

        for(int[] newInterval : intervals){
            int currentEnd = current[1];
            int nextStart = newInterval[0];
            int nextEnd = newInterval[1];

            if(currentEnd>=nextStart){
                current[1] = Math.max(currentEnd,nextEnd);
            }else{
                current = newInterval;
                res.add(current);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}