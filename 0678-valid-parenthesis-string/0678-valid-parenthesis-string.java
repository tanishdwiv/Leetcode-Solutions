class Solution {
    public boolean checkValidString(String s) {
      int  openbracket=0;
       int closebracket=0;
       int len=s.length();
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='('||s.charAt(i)=='*'){
            openbracket++;
           }
           else{
            openbracket--;
           }

           if(s.charAt(len-i-1)==')'||s.charAt(len-i-1)=='*'){
            closebracket++;
           }
           else{
            closebracket--;
           }
           if(openbracket<0||closebracket<0)
           return false;
           
        }
        
        return true;
    }
}