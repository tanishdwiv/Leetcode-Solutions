class Solution {
    public boolean canPartition(int[] nums) {
        // int n=nums.length;
        // int sum=0;
        // for(int i=0;i<nums.length;i++){
        //     sum=sum+nums[i];
        // }
        // if((sum % 2)!=0) return false;
        // int target=sum/2;

        //  boolean dp[][]=new boolean[n][target+1];
        //   for(int i=0;i<n;i++){
        //     dp[i][0]=true;
        //   }
        //   if(nums[0]<=target){
        //     dp[0][nums[0]]=true;
        //   }
        //   for(int index=1;index<n;index++){
        //     for(int tar=1;tar<=target;tar++){
        //         boolean nottake=dp[index-1][tar];
        //         boolean take=false;
        //         if(nums[index]<=tar){
        //             take=dp[index-1][tar-nums[index]];
        //         }
        //         dp[index][tar]=take||nottake;
        //     }
        //   }
        //   return dp[n-1][target];
     int tot=0;
    
     for(int i=0;i<nums.length;i++){
        tot=tot+nums[i];
     }
     if(tot%2!=0) return false;
     tot=tot/2;
     int[][] dp=new int[nums.length][tot+1];
     for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
     return subset(nums,nums.length-1,tot,dp);


}
static boolean subset(int arr[],int index,int target,int[][] dp){
        if(target==0)
        return true;
        if(index==0)
        return arr[0]==target;
        if (dp[index][target] != -1)
            return dp[index][target]==1;
        
        boolean nottake=subset(arr,index-1,target,dp);
        boolean take=false;
        if(target>=arr[index])
        take=subset(arr,index-1,target-arr[index],dp);
        
     dp[index][target] = (take||nottake) ? 1 : 0; 
        return dp[index][target] == 1;

}
}