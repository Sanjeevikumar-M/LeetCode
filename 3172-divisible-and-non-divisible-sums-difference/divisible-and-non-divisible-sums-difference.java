class Solution {
    public int differenceOfSums(int n, int m) {
        int inSum = 0;
        int notInSum = 0;
        for(int i=0;i<=n;i++){
            if(i%m==0){
                inSum += i;
            }else{
                notInSum += i;
            }
        }
        return notInSum - inSum;
    }
}