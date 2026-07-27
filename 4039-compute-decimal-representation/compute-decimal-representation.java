class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> l = new ArrayList<>();
        int place = 1;

        while(n>0){
            int d = n%10;
            if(d!=0){
                l.add(d*place);
            }
            place*=10;
            n/=10;
        }
        int[] res = new int[l.size()];
        int i = l.size()-1;
        for(int j:l){
            res[i--] = j;
        }
        return res;
    }
}