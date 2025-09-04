class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] memo=new int[n+1][target+1];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return solve(n,k,target,memo);
    }
    int solve(int n,int k,int target,int[][] memo){
       
        if(n==0 && target==0){
            return 1 ;
        }
         if(n==0){
            return 0;
        }
        if(memo[n][target]!=-1){
            return memo[n][target];
        }
        int ans=0;
       int mod = 1_000_000_007;
        for(int i=1;i<=k;i++){
            if(target>=i){
            ans=(ans+solve(n-1,k,target-i,memo))%mod;
            }
        }
        return memo[n][target]=ans;
    }
}