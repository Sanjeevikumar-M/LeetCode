class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minFinishTime = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int landFinish = landStartTime[i]+landDuration[i];
                int waterStart = Math.max(landFinish,waterStartTime[j]);
                int finalFinish1 = waterStart + waterDuration[j];

                int waterFinish = waterStartTime[j]+waterDuration[j];
                int landStart = Math.max(waterFinish,landStartTime[i]);
                int finalFinish2 = landStart + landDuration[i];

                minFinishTime = Math.min(minFinishTime,Math.min(finalFinish1,finalFinish2)); 
            }
        }
        return minFinishTime;
    }
}