class Solution {
    public int rob(int[] nums) {
        
      int n = nums.length;
        if (n == 1) return nums[0]; 
        if (n == 2) return Math.max(nums[0], nums[1]); 
         int memo[]=new int[n+1];
           Arrays.fill(memo,-1);
      // Rob houses [0 se n-2]
        int case1 = loot(nums, 0, n - 2,memo);
     // Rob houses [1 se n-1]
     //again modifying values becuse it can use previous memo filled array

      Arrays.fill(memo,-1);
        int case2 = loot(nums, 1, n - 1,memo);

        return Math.max(case1, case2);
    }
     public  int loot(int[] robber,int i, int n, int[] memo)
         { 
          if (n <i) return 0;
          if (memo[n] != -1) return memo[n]; 
          int include = robber[n] + loot(robber,i, n - 2, memo); 
          int exclude = loot(robber,i, n - 1, memo);
          memo[n] = Math.max(include, exclude);
          return memo[n]; 
          }

}