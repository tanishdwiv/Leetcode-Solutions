class Solution {
    private int[][] obstacleGrid;
    private int[][] memo;
    private int m;
    private int n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.obstacleGrid = obstacleGrid;
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;

       
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
         this.memo = new int[m][n];
          for(int[] r:memo){
        Arrays.fill(r,-1);
    }
    return solve(0,0,m,n,memo);
        
    }
     int solve(int row,int col,int m,int n,int[][] memo){
         
         if(row>=m || col>=n){
            return 0;
        }
          if(obstacleGrid[row][col]==1){
            return 0;  //obstacle
        }
        if(row==m-1 && col==n-1){
            return 1;//i am on my target
        }
      
       
       
        if(memo[row][col]!=-1){
            return memo[row][col];
        }
        memo[row][col]=solve(row+1,col,m,n,memo)+solve(row,col+1,m,n,memo);//either we can go right or down
    
    return memo[row][col];
    }
}