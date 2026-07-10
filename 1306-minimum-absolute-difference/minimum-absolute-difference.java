class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            int diff = Math.abs(arr[i]-arr[i-1]);
            min = Math.min(min, diff);
        }
        for(int i=1;i<arr.length;i++){
            List<Integer> ans = new ArrayList<>();
            int diff = Math.abs(arr[i]-arr[i-1]);
            if(min==diff){
                ans.add(arr[i-1]);
                ans.add(arr[i]);
                result.add(ans);
            }
        }

        return result;
    }
}