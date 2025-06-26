class Solution {
    public String removeOuterParentheses(String s) {
        // Stack<Character> stack=new Stack<>();
        // StringBuilder sb=new StringBuilder();
        // for(char c:s.toCharArray()){
        //     if(c=='('){
        //     if(!stack.isEmpty()){//jb tk stack khali nhi h
        //     sb.append(c);
        // }
        // stack.push(c);
        // }
        // else{
        //     stack.pop();//jodi daar mil gya
        //       if(!stack.isEmpty()){//jb tk stack khali nhi h
        //     sb.append(c);
        // }
        // }
        // }
        // return sb.toString();

        //using count variable
         Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            if(ch=='('){//agar pehle open h toh add krdo ...aur fir count bADHA DO
                if(count>0){
                    sb.append(ch);
                }
                count++;
            }
            else{//agar mera bracket ')' hai toh pehle count decrease krdo fir check kro ki kya voh abhi bhi greater than 0 h toh add krdo
                count--;
                if(count>0){
                    sb.append(ch);
                }
            }
            
        }
        return sb.toString();

    }
}