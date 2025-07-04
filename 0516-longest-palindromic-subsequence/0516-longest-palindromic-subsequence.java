class Solution {
    public int longestPalindromeSubseq(String s) {
         StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();
        int m=s.length();
        int n=reversed.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) { for (int j = 0; j <= n; j++)
        {
            dp[i][j] = -1;
        }
        }
        return lcs(s,reversed,m,n,dp);

    }
     int lcs(String s1,String s2,int m,int n,int[][] dp){

        if(m==0||n==0)
            return 0;
        if(dp[m][n]!=-1)
            return dp[m][n];
        if(s1.charAt(m-1)==s2.charAt(n-1))
            dp[m][n]=1+lcs(s1,s2,m-1,n-1,dp);
        else
            dp[m][n]= Math.max(lcs(s1,s2,m-1,n,dp),lcs(s1,s2,m,n-1,dp));
        return dp[m][n];
    }
}