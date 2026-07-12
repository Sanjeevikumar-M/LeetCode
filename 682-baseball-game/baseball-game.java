class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String i:operations){
            if(i.equals("C")){
                stack.pop();
            }else if(i.equals("D")){
                stack.push(stack.peek()*2);
            }else if(i.equals("+")){
                int top = stack.pop();
                int newtop = stack.peek() + top;
                stack.push(top);
                stack.push(newtop);
            }else{
                stack.push(Integer.parseInt(i));
            }
        }
        int sum = 0;
        for(int s:stack){
            sum += s;
        }
        return sum;
    }
}