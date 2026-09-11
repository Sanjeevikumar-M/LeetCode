class Solution {
    public String reversePrefix(String word, char ch) {
        int left = 0;
        int right = 0;
        int n = word.length();
        boolean isFound = false;
        while(right<n){
            if(word.charAt(right) == ch){
                right++;
                isFound = true;
                break;
            }
            right++;
        }
        
        if(isFound){
            String ss = word.substring(left,right);
            String remss = word.substring(right,n);
            char[] cha = ss.toCharArray();
            right--;
            while(left<right){
                char c = cha[left];
                cha[left] = cha[right];
                cha[right] = c;
                left++;
                right--;
            }
            String revss = new String(cha);
            String res = revss + remss;
            return res;
        }else{
            return word;
        }
    }
}