class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0){
            return new ArrayList<>();
        }
        if(numRows == 1){
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
            return result;
        }
        result = generate(numRows-1);
        List<Integer> prerow = result.get(numRows-2);
        List<Integer> currrow = new ArrayList<>();
        currrow.add(1);
        for(int i=1;i<numRows-1;i++){
            currrow.add(prerow.get(i-1)+prerow.get(i));
        }
        currrow.add(1);
        result.add(currrow);
        return result;
    }
}