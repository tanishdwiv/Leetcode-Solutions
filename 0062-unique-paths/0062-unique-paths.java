class Solution {
    public int uniquePaths(int m, int n) {
    //     int dp[][]=new int[m][n];
    //     return uniquepaths(0,0,m,n,dp);
    // }
    // static int uniquepaths(int i,int j,int m,int n,int[][] dp){
    //     if(i>=m||j>=n)
    //     return 0;

    //     if(i==m-1 && j==n-1)
    //     return 1;

    //     if(dp[i][j] >0)
    //     return dp[i][j];

    //     dp[i][j]=uniquepaths(i+1,j,m,n,dp) + uniquepaths(i,j+1,m,n,dp);
    //     return dp[i][j];

    int[][] memo=new int[m+1][n+1];
    for(int[] r:memo){
        Arrays.fill(r,-1);
    }
    int row=0;
    int col=0;
    return solve(row,col,m,n,memo);
    }
    int solve(int row,int col,int m,int n,int[][] memo){
        if(row==m-1 && col==n-1){
            return 1;//i am on my target
        }
        if(row>=m || col>=n){
            return 0;
        }
        if(memo[row][col]!=-1){
            return memo[row][col];
        }
        memo[row][col]=solve(row+1,col,m,n,memo)+solve(row,col+1,m,n,memo);//either we can go right or down
    
    return memo[row][col];
    }
}