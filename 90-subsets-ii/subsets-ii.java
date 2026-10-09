class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        generate(res,list,nums,0);
        return res;
    }

    public void generate(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
        if(index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        generate(res,list,nums,index+1);
        list.remove(list.size()-1);
        int i=index+1;
        while(i<nums.length && nums[i]==nums[index]){
            i++;
        }
        generate(res,list,nums,i);
    }
}