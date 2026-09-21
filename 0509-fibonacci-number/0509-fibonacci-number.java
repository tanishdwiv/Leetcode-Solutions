class Solution {
    // public int fib(int n) {
       
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp, -1);
    //     return f(n,dp);
        
    // }
    // static int f(int n,int[]dp){
    //      if(n<=1)
    //     return n;
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     dp[n]=f(n-1,dp)+f(n-2,dp);
    //     return dp[n];
    // }
      public int fib(int n) {

        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}