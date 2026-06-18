class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n<3){
            return false;
        }
        int i = 0;
        int j = n-1;
        while(i<j){
            if(arr[i]<arr[i+1]){
                i++;
            }else if(arr[j]<arr[j-1]){
                j--;
            }else{
                return false;
            }
        }
        return i==j && (i!=0 && j!=n-1) ? true : false;
    }
}