class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = 0;
        for (int num : nums) {
            high = Math.max(high, num);
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMake(nums, mid, maxOperations)) {
                ans = mid;
                high = mid - 1; // try smaller penalty
            } else {
                low = mid + 1; // penalty too small, try bigger
            }
        }
        return ans;
    }

    private boolean canMake(int[] nums, int X, int maxOperations) {
        int totalCuts = 0;
        for (int num : nums) {
            if (num > X) {
                int piecesNeeded = (int) Math.ceil((double) num / X);
                totalCuts += piecesNeeded - 1;
                if (totalCuts > maxOperations) return false;
            }
        }
        return true;
    }
}
