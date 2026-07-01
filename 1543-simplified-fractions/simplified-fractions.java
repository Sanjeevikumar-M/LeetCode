class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        HashSet<Float> set = new HashSet<>();

        for(int i=1;i<n;i++){
            for(int j=i+1;j<=n;j++){
                float f = (float) i/j;
                if(!set.contains(f)){
                    set.add(f);
                    result.add((i+"/"+j));
                }
            }
        }
        return result;
    }
}