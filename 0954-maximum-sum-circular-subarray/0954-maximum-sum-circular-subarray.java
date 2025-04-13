class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxsum=Integer.MIN_VALUE;
        int minsum=Integer.MAX_VALUE;
        int curr1=0,curr2=0,total=0;
        //finding maximum sum subarray using kadanes
        for(int i=0;i<nums.length;i++){
        curr1+=nums[i];
        maxsum=Math.max(maxsum,curr1);
        curr1=Math.max(curr1,0);
//minimum subarray sum
         curr2+=nums[i];
        minsum=Math.min(minsum,curr2);
        curr2=Math.min(curr2,0);
        
        total+=nums[i];
        }
        return maxsum<0?maxsum:Math.max(maxsum,total-minsum);
    }
}