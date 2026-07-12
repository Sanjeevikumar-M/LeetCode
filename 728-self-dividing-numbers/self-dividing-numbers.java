class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> l = new ArrayList<>();
        while(left<=right){
            boolean isValid = true;
            for(char ch:String.valueOf(left).toCharArray()){
                int n = ch - '0';
                if(n==0){
                    isValid = false;
                    break;
                }
                if(left%n!=0){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                l.add(left);
            }
            left++;
        }
        return l;
    }
}