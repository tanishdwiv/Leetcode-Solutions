class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int ele : piles) {
            max = Math.max(ele, max);
        }

        int start = 1, end = max;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long hours = countHours(piles, mid); // ⬅️ use long

            if (hours <= h) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    static long countHours(int[] arr, int k) {
        long hr = 0;
        for (int val : arr) {
            hr += (val + (long)k - 1) / k;
        }
        return hr;
    }
}
