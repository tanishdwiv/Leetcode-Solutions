class Solution {
    public int minSubArrayLen(int target, int[] nums) {
    //     if (nums == null || target < 0) {
    //         throw new IllegalArgumentException("Input array is null");
    //     }

    //     int len = nums.length;
    //     int start = 1;
    //     int end = len;
    //     int minLen = len + 1;

    //     while (start <= end) {
    //         int mid = start + (end - start) / 2;
    //         int foundWindowSize = windowExists(nums, target, mid);
    //         if (foundWindowSize > 0) {
    //             end = foundWindowSize - 1;
    //             minLen = foundWindowSize;
    //         } else {
    //             start = mid + 1;
    //         }
    //     }

    //     return minLen % (len + 1);
    // }

    // private int windowExists(int[] nums, int target, int maxWindowSize) {
    //     int foundWindowSize = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         target -= nums[i];
    //         foundWindowSize++;

    //         if (i >= maxWindowSize) {
    //             foundWindowSize--;
    //             target += nums[i - maxWindowSize];
    //         }

    //         if (target <= 0) {
    //             return foundWindowSize;
    //         }
    //     }

    //     return -1;

    // int total=Integer.MAX_VALUE; //for counting length
    // int start=0;
    // int end=0;
    // int len=nums.length;
    // int sum=0;
    // while(end<len){
    //     sum=sum+nums[end];
        
    //     while(sum>=target){
    //         total=Math.min(total,end-start+1);
    //         sum=sum-nums[start++];
    //     }
    //     end++;
        
    // }
    // return total==Integer.MAX_VALUE?0:total; //agar total=max ke barabar h toh zero nhi toh minimum return krdo



    int low=0;
    int high=0;
    int n=nums.length;
    int result=Integer.MAX_VALUE;
    int sum=0;
    while(high<n){
        sum=sum+nums[high];
        while(sum>=target){
            result=Math.min(result,high-low+1);
            sum=sum-nums[low];
            low++;
        }
        high++;

    }
    return result==Integer.MAX_VALUE?0:result;
    }
}