class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='('){
            if(!stack.isEmpty()){//jb tk stack khali nhi h
            sb.append(c);
        }
        stack.push(c);
        }
        else{
            stack.pop();//jodi daar mil gya
              if(!stack.isEmpty()){//jb tk stack khali nhi h
            sb.append(c);
        }
        }
        }
        return sb.toString();
    }
}