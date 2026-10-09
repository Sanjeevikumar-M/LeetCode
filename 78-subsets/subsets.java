class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        generate(list,nums,0);
        return res;
    }
    private void generate(List<Integer> list, int[] nums, int index){
        if(index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        generate(list,nums,index+1);
        list.remove(list.size()-1);
        generate(list,nums,index+1);
    }
}