
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1); 
        }

        int result = solve(coins, 0, amount, memo);

        return (result >= 1_000_000_000) ? -1 : result;
    }

    private int solve(int[] coins, int index, int amount, int[][] memo) {
    
        if (amount == 0) {
            return 0;
        }

       
        if (index >= coins.length || amount < 0) {
            return 1_000_000_000; 
        }

       
        if (memo[index][amount] != -1) {
            return memo[index][amount];
        }

       
        int dontTake = solve(coins, index + 1, amount, memo);

        int take = 1 + solve(coins, index, amount - coins[index], memo);

        
        return memo[index][amount] = Math.min(take, dontTake);
    }
}