class Solution {
    public int numDifferentIntegers(String word) {
        HashSet<String> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int n = word.length();
        while(right<n){
            while(right<n && !Character.isDigit(word.charAt(right))){
                right++;
            }
            left = right;
            while(right<n && Character.isDigit(word.charAt(right))){
                right++;
            }
            if(left<right){
                String numStr = word.substring(left, right);
                numStr = numStr.replaceFirst("^0+", "");

                if (numStr.isEmpty()) {
                    numStr = "0";
                }
                
                set.add(numStr);
            }
        }
        return set.size();
    }
}