class Solution {
    public boolean backspaceCompare(String s, String t) {
      return backspace(s).equals(backspace(t));
    }
    public String backspace(String s){
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='#'){
                if(!stack.isEmpty())
                stack.pop();    
            }
            else{
                stack.push(ch);
            }
        }
    StringBuilder sb = new StringBuilder();
    for (Character c : stack) {
        sb.append(c);
    }
    return sb.toString();
    }
}