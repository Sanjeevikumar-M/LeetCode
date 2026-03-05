class Solution {
    public int minOperations(String s) {
        int count1 = 0; // pattern starting with 0
        int count2 = 0; // pattern starting with 1
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            // Pattern: 010101...
            if(i % 2 == 0){
                if(c != '0') count1++;
            } else {
                if(c != '1') count1++;
            }
            
            // Pattern: 101010...
            if(i % 2 == 0){
                if(c != '1') count2++;
            } else {
                if(c != '0') count2++;
            }
        }
        
        return Math.min(count1, count2);
    }
}