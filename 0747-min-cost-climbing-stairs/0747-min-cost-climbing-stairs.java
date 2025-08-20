class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int prev2=cost[0];
        // int prev=cost[1];
        // for(int i=2;i<cost.length;i++){
        //     int curri=cost[i] + Math.min(prev,prev2);
        //     prev2=prev;
        //     prev=curri;
        // }
        // return Math.min(prev,prev2);
        //recursion
   
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(solve(cost,dp,0), solve(cost,dp,1));
    }
    public int solve(int[] cost, int[]dp,int i){
        if(i>= cost.length) return 0;
        if(dp[i]!=-1) return dp[i];

        int take1 = cost[i]+ solve(cost, dp,i+1);
        int take2= cost[i] +solve(cost,dp,i+2);

        return dp[i] = Math.min(take1,take2);
    }
}
 