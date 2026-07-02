class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();

        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                if(gcd(j,i)==1){
                    result.add(j+"/"+i);
                }
            }
        }   
        return result;
    }

    private static int gcd(int a,int b){
        return b==0 ? a : gcd(b,a%b);
    }
}