class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int count = 0;
        int total = 0;
        for(int i:apple){
            total+=i;
        }

        for(int i=capacity.length-1;i>=0;i--){
            total -= capacity[i];
            if(total>0){
                count++;
            }else{
                break;
            }
        }
        return count+1;
    }
}