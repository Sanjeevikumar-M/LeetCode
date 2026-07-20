class Solution {
    public int[] transformArray(int[] nums) {
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]%2==0){
        //         nums[i] = 0;
        //     }else{
        //         nums[i] = 1;
        //     }
        // }
        // Arrays.sort(nums);
        // return nums;
        int []result = new int[nums.length];
    
        int odd = 0;

        for(int num : nums) {
            if(num % 2 != 0) odd++;
        }

        int index = nums.length - 1;

        while(odd > 0) {
            result[index--] = 1;
            odd--;
        }
        return result;
        
    }
}