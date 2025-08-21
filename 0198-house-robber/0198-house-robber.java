class Solution {
    public int rob(int[] nums) {
    int n=nums.length;
    int memo[]=new int[n+1];
     Arrays.fill(memo, -1);
    return Loot(nums,n,memo);
    }
    
        public  int Loot(int[] robber, int n, int[] memo)
         { 
          if (n <= 0) return 0;
          if (memo[n] != -1) return memo[n]; 
          int include = robber[n - 1] + Loot(robber, n - 2, memo); 
          int exclude = Loot(robber, n - 1, memo);
          memo[n] = Math.max(include, exclude);
          return memo[n]; 
          }
    }







        //     return recursion(nums, nums.length - 1);
    // }

    // private int recursion(int[] nums, int n) {
    //     if (n < 0) return 0; // Base case: no houses left to rob
    //     if (n == 0) return nums[0]; // Only one house to rob

    //     int robCurrent = nums[n] + recursion(nums, n - 2);
    //     int skipCurrent = recursion(nums, n - 1);
    //     return Math.max(robCurrent, skipCurrent); // Take the max of both choices
//top down

    //     int n = nums.length;
    //     int[] memo = new int[n + 1]; // Initialize memo array
    //     return maxLootRec(nums, n, memo);
    // }

    // private int maxLootRec(int[] hval, int n, int[] memo) {
    //     if (n <= 0) return 0;
    //     if (memo[n] != 0) return memo[n];

    //     int includeCurrent = hval[n - 1] + maxLootRec(hval, n - 2, memo);
    //     int excludeCurrent = maxLootRec(hval, n - 1, memo);

    //     memo[n] = Math.max(includeCurrent, excludeCurrent);
    //     return memo[n];
    // }

// //bottom up
   
//         if (nums.length == 0) return 0;
//         if (nums.length == 1) return nums[0];

//         // Initialize an array to store the maximum money that can be robbed up to each house
//         int[] dp = new int[nums.length];
//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0], nums[1]);

//         for (int i = 2; i < nums.length; i++) {
//             // For each house, calculate the maximum money that can be robbed
//             dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
//         }

//         // The last element in dp array will have the maximum money that can be robbed
//         return dp[nums.length - 1];
//     }

   


