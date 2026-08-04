class Solution {
    public int countCommas(int n) {
        int digiCount = 0;
        int temp = n;
        while(temp>0){
            digiCount++;
            temp/=10;
        }
        if(digiCount < 4) return 0;
        return n-1000 + 1;
    }
}