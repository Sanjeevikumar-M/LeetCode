class Solution {
    public String removeDuplicates(String s) {
        char[] arr = s.toCharArray();
        int j = 0;
        for(int i=0;i<arr.length;i++){
            if(j==0 || arr[i]!=arr[j-1]){
                arr[j++] = arr[i];
            }else{
                j--;
            }
        }
        return new String(arr,0,j);
    }
}