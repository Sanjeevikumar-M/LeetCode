class Solution {
    public int compress(char[] chars) {
        int left = 0;
        int n = chars.length;
        for(int right=0;right<n;){
            char letter = chars[right];
            int count = 0;
            while(right<n && chars[right] == letter){
                ++count;
                ++right;
            }
            chars[left++] = letter;
            if(count>1){
                for(char ch:String.valueOf(count).toCharArray()){
                    chars[left++] = ch;
                }
            }
        }
        return left;
    }
}