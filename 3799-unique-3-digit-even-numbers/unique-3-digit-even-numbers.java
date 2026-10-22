class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(i!=j&&j!=k&&k!=i){
                        if(digits[i]!=0){
                            if(digits[k]%2==0){
                                set.add(digits[i]*100+digits[j]*10+digits[k]);
                            }
                        }
                    }
                }
            }
        }
        return set.size();
    }
}