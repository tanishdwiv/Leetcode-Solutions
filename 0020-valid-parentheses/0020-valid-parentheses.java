class Solution {
    public boolean isValid(String s) {
        //  Stack<Character> stack = new Stack<>();
        // for(char c : s.toCharArray()) {
        //     if(c=='(')
        //     stack.push(')');
        //     else if(c=='{')
        //     stack.push('}');
        //     else if(c=='[')
        //     stack.push(']');

        //     else if(stack.isEmpty() || stack.pop()!=c)
            
            
        // }
        // return stack.isEmpty();

        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if((c=='(') || (c=='{') || (c=='['))
            {
                stack.push(c);
            }
            else 
            {
        if(!stack.isEmpty() && ((stack.peek()=='(' && c==')') || (stack.peek()=='{' && c=='}') || (stack.peek()=='[' && c==']'))) {
            stack.pop();
            }
            else{
                return false;
            }
        }
        }
        return stack.isEmpty();
     
    }
}