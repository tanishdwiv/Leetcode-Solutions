class Solution {
    public int numDecodings(String s) {
        int[] memo=new int[s.length()+1];
        Arrays.fill(memo,-1);
        return solve(s,0,memo);

    }
    int solve(String s,int i,int[] memo){
       
        if(i==s.length()){
            return 1; //i have found an valid decoded string
        }
         if(s.charAt(i)=='0') {
            return 0;
        }
        if(memo[i]!=-1){
            return memo[i];
        }
        int ans=0;
        ans=solve(s,i+1,memo);
        if(i+1<s.length()){
            int twodigit=Integer.parseInt(s.substring(i,i+2));
        if(twodigit>=10 && twodigit<=26){
            ans+=solve(s,i+2,memo);
        }
        }
        return memo[i]=ans;
    }
}