class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] arr = new int[26];
        for(char i:text.toCharArray()){
            arr[i-'a']++;
        }
        int min = Integer.MAX_VALUE;
        for(int i:arr){
            min = Math.min(arr[0],min);
            min = Math.min(arr[1],min);
            min = Math.min(arr[11]/2,min);
            min = Math.min(arr[13],min);
            min = Math.min(arr[14]/2,min);
        }
        return min;
    }
}