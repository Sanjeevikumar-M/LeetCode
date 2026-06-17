class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push('(');
            }else if(c=='['){
                stack.push('[');
            }else if(c=='{'){
                stack.push('{');
            }else if(c==')'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek()!='('){
                    return false;
                }
                stack.pop();
            }else if(c==']'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek()!='['){
                    return false;
                }
                stack.pop();
            }else if(c=='}'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek()!='{'){
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}