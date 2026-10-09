class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, solve(0, j, matrix, dp));
        }

        return ans;
    }

    private int solve(int i, int j, int[][] matrix, int[][] dp) {
        int n = matrix.length;

        if (j < 0 || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (i == n - 1) {
            return matrix[i][j];
        }

        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int down = solve(i + 1, j, matrix, dp);

        int left = j > 0
                ? solve(i + 1, j - 1, matrix, dp)
                : Integer.MAX_VALUE;

        int right = j < n - 1
                ? solve(i + 1, j + 1, matrix, dp)
                : Integer.MAX_VALUE;

        int best = Math.min(down, Math.min(left, right));

        dp[i][j] = matrix[i][j] + best;

        return dp[i][j];
    }
}