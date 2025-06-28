class Solution {
    public String minRemoveToMakeValid(String s) {
        //in this ques we will traverse the string from left to right and then left to right to check if there is not an extra parenthesis and will add lowercase as it is in the stack and will take counter to count the exact number of valid parenthesis

        //lefttoright
        Stack<Character> stack=new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')' && count==0)//agar mera count  hai aur mujhe pehle closing parenthesis mil gya h toh mai usse stack mai add nhi krunga kyuki uska correspondence exist nhi krega
            {
                continue;
            }
            if(ch=='(' ){
                count++;
            }
            else if(ch==')'){
                count--;
            }
           stack.push(ch);
        }


        //righttoleft for checking if extra parenthesis are there
        StringBuilder sb=new StringBuilder();
        count=0; //make count 0
        while(!stack.isEmpty()){
            char c=stack.pop();
            if(c=='(' && count==0)//agar mera right to left traverse krte time pehle opening mil jata h toh we will not add 
            {
            continue;
            }
             if(c==')' ){
                count++;
            }
            else if(c=='('){
                count--;
            }
           sb.append(c);
        }

        return sb.reverse().toString();
        
    }
}