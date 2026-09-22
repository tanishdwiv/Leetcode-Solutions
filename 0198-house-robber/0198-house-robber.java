class Solution {
    // public int rob(int[] nums) {
    //     return f(nums.length-1,nums);
        
    // }
    // static int f(int i,int[] nums){
    //     if(i<0){
    //         return 0;
    //     }
    //     int rob=nums[i]+f(i-2,nums);
    //     int skip=f(i-1,nums);
    //     return Math.max(rob,skip);
    // }

    int[] dp;

    public int rob(int[] nums) {

        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return f(nums.length - 1, nums);
    }

    public int f(int i, int[] nums) {

        // Base case
        if (i < 0) {
            return 0;
        }

        // Already calculated?
        if (dp[i] != -1) {
            return dp[i];
        }

        // Take current house
        int take = nums[i] + f(i - 2, nums);

        // Skip current house
        int skip = f(i - 1, nums);

        // Store and return
        return dp[i] = Math.max(take, skip);
    }
}