class Solution {
   
        // if(n==1) return 1;
        
        // if(n==2) return 2;

        // int[] a =  new int[n];
        // a[0]=1;
        // a[1]=2;

        // for(int i=2;i<n;i++){
        //     a[i]=a[i-1]+a[i-2];
        // }
        // return a[n-1];

     public int climb(int n,int[]dp){
        if(n<2)return 1;
        if(dp[n]!=-1)return dp[n];
        return dp[n]=climb(n-1,dp)+climb(n-2,dp);

    }
     
    
    public int climbStairs(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        return climb(n,dp);

    }
}