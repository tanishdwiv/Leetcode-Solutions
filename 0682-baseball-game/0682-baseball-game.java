class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack=new Stack<>();
        for(String op:operations){
            if(op.equals("C")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(op.equals("D")){
                 stack.push(2 * stack.peek()); 
            } else if (op.equals("+")) {
                int last = stack.pop();
                int secondlast = stack.peek();
                int newscore = last + secondlast;
                stack.push(last);        
                stack.push(newscore);    
            } else {
                stack.push(Integer.parseInt(op)); 
            }
        }

        int total = 0;
        for (int score : stack) {
            total += score;
        }
        return total;
            }
    
        
    
}