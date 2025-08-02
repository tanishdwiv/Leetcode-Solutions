class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

         List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) {
            return result;
        }

        // Min-heap stores an array: [sum, index_in_nums1, index_in_nums2]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 1. Seed the heap with the first element from each "conceptual list".
        // We only need to consider the first k elements of nums1, as any pair
        // starting after that is unlikely to be in the top k smallest sums.
        for (int i = 0; i < nums1.length && i < k; i++) {
            // The smallest pair for nums1[i] is with nums2[0].
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        // 2. The main loop runs until we've found k pairs or the heap is empty.
        while (k > 0 && !minHeap.isEmpty()) {
            // a. Extract the pair with the globally smallest sum.
            int[] current = minHeap.poll();
            int i = current[1]; // Index from nums1
            int j = current[2]; // Index from nums2

            // b. Add the found pair to our result.
            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // c. Add the next element from the same list that current came from.
            // If the list for nums1[i] is not exhausted (i.e., j+1 is valid)...
            if (j + 1 < nums2.length) {
                // ...add the next pair (nums1[i], nums2[j+1]) to the heap.
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        
        return result;
        
    }
}