class Solution {
    public String makeGood(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(!stack.isEmpty() && Math.abs(stack.peek()-ch)==32){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
         StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}