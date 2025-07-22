class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)->b-a);
        int left = 0;
        int right = 0;
        int n = nums.length;
        int ans = 0;
        while(right < n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            maxheap.offer(nums[right]);
            minheap.offer(nums[right]);
            while(maxheap.peek() - minheap.peek() > limit && left < right){
                map.put(nums[left],map.get(nums[left])-1);
                while(!maxheap.isEmpty() && map.get(maxheap.peek()) == 0)
                    maxheap.poll();
                while(!minheap.isEmpty() && map.get(minheap.peek()) == 0)
                    minheap.poll();
                left++;                    
            }
            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}