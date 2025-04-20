class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p=new PriorityQueue<>(); //this will be default min heap
        for(int i=0;i<nums.length;i++)
        p.add(nums[i]);
        while(p.size()>k){
            p.poll();

        }
        return p.peek();
        
    }
}