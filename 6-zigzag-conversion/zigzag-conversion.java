class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || s.length() < numRows){
            return s;
        }

        StringBuilder[] res = new StringBuilder[numRows];

        for(int i=0;i<numRows;i++){
            res[i] = new StringBuilder();
        }

        int currentRow = 0;
        int direction = 1;

        for(char ch:s.toCharArray()){
            res[currentRow].append(ch);

            if(currentRow == 0){
                direction = 1;
            }else if(currentRow == numRows-1){
                direction = -1;
            }

            currentRow += direction;
        }

        StringBuilder sb = new StringBuilder();

        for(StringBuilder rows:res){
            sb.append(rows);
        }

        return sb.toString();
    }
}