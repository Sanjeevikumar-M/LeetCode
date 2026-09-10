class Solution {
    public int distinctIntegers(int n) {
        Set<Integer> set = new HashSet<>();
        for(int i=n-1;i>1;i--){
            if(n%i==1){
                n=i;
                set.add(i);
            }
        }
        return set.size()+1;
    }
}