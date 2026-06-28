class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int[] res = new int[arr.length];
        int max = 1;
        res[0] = 1;
        for(int i=0;i<arr.length-1;i++){
            int diff = arr[i+1]-res[i];
            if(diff<=1){
                res[i+1] = arr[i+1];
                max = Math.max(res[i+1],max);
                continue;
            }
            res[i + 1] = res[i] + 1;
            max = Math.max(res[i+1],max);
        }
        return max;
    }
}