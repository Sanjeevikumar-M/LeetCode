class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || numRows>s.length()){
            return s;
        }
        StringBuilder[] res = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            res[i] = new StringBuilder();
        }
        int curr = 0;
        int dire = 0;
        for(char ch:s.toCharArray()){
            res[curr].append(ch);
            if(curr==0){
                dire = 1;
            }else if(curr == numRows-1){
                dire = -1;
            }
            curr += dire;
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<numRows;i++){
            ans.append(res[i]);
        }
        return ans.toString();
    }
}