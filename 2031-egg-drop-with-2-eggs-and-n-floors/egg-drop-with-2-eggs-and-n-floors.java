class Solution {
    public int twoEggDrop(int n) {
        int count = 0;
        int i = 0;
        while(count<n){
            count += i;
            i++;
        }
        return i-1;
    }
}