class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1); 
        }
 int result = solve(coins, 0, amount, memo);

        return  result;
        
    }
    int solve(int[] coins, int index, int amount, int[][] memo) {
     if (amount == 0) {
            return 1;
        }
 if (index >= coins.length || amount < 0) {
            return 0; 
        }
        if (memo[index][amount] != -1) {
            return memo[index][amount];
        }  
 int dontTake = solve(coins, index + 1, amount, memo);

int take = solve(coins, index, amount - coins[index], memo);
       
 
        return memo[index][amount] = take+dontTake;
    }
}