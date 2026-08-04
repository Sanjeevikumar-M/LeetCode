class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        int j = 0;
        int i = nums[0];
        int k = nums[n-1];
        while(j<n){
            if(nums[j]!=i){
                list.add(i);
                i++;
            }else{
                j++;
                i++;
            }
        }
        while(i<k){
            list.add(i);
            i++;
        }
        return list;
    }
}