class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();
        for(char digit : num.toCharArray()){
            //builind stack of smaller numbers
            while(!stack.isEmpty() && k>0 && stack.peek()>digit){
             stack.pop();
             k--;
            }
            stack.push(digit);
        }
        //if still my k>0
        while(k>0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        //build string
        StringBuilder sb=new StringBuilder();
        for(char c:stack){
            sb.append(c);
        }
        //remove zero from starting
     while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
     }
     return sb.length()==0?"0":sb.toString();
        
    }
}