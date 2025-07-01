class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        stack.push(0);//pehle se ek 0 daal denge taki empty condition na ho
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(0);
            }
            else{
                int inner=stack.pop();
                int outer=stack.pop();
                int totalscore=outer+Math.max(2*inner,1);
                stack.push(totalscore);

            }
        }
        return stack.pop();
    }
}