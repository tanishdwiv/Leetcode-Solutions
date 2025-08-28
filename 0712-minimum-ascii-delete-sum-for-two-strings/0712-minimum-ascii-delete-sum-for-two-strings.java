class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] memo = new int[s1.length()][s2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1); 
        }
        return solve(s1, 0, s2, 0,memo);
    }
    private int solve(String s1, int i, String s2, int j,int[][] memo) {
        // Base Case 1: If s1 is exhausted, we must delete the rest of s2.
        if (i == s1.length()) {
            int remainingSum = 0;
            for (int k = j; k < s2.length(); k++) {
                remainingSum += s2.charAt(k);
            }
            return remainingSum;
        }
 // Base Case 2: If s2 is exhausted, we must delete the rest of s1.
        if (j == s2.length()) {
            int remainingSum = 0;
            for (int k = i; k < s1.length(); k++) {
                remainingSum += s1.charAt(k);
            }
            return remainingSum;
        }

         if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return solve(s1, i + 1, s2, j + 1,memo);
        } else {
        
            int deletefroms1 = s1.charAt(i) + solve(s1, i + 1, s2, j,memo);
            int deletefroms2 = s2.charAt(j) + solve(s1, i, s2, j + 1,memo);
            
            return memo[i][j]=Math.min(deletefroms1, deletefroms2);
        }
    }
}