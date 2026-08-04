class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i:nums){
            if(i<min){
                min = i;
            }
            if(i>max){
                max = i;
            }
        }

        int[] arr = new int[max+1];
        for(int i:nums){
            arr[i]++;
        }
        for(int i=min;i<max;i++){
            if(arr[i]==0){
                list.add(i);
            }
        }
        return list;
    }
}