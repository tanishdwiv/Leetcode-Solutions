class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int  right = 1000_000_000;
        int ans = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            int ops = 0;

            for (int n : nums) {
                ops += (n - 1) / mid;
                if (ops > maxOperations) {
                    break;
                }
            }

            if (ops <= maxOperations) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}