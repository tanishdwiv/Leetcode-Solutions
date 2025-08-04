class Solution {
    public int findMin(int[] nums) {
        // int n=nums.length;
        // int ans=Integer.MAX_VALUE;
        // int low=0;
        // int high=n-1;
        // while(low<=high){
        //     int mid=low+(high-low)/2;
        //     if(nums[low]<=nums[mid]){
        //         ans=Math.min(ans,nums[low]);
        //         low=mid+1;
        //     }
        //     else{
        //         ans=Math.min(ans,nums[mid]);
        //         high=mid-1;
        //     }
        // }
        // return ans;
        int n=nums.length;
        int start=0;
        int end=n-1;
        int ans=nums[0];
        while(start<=end){
        int mid=start+(end-start)/2;
        //checking with nums[0] so that we can determine left part sorted or right part sorted
        if(nums[mid]>=nums[0]){//left part sorted so we will move further for minimum
        start=mid+1;
        }
        else {//right part

         ans=nums[mid];//kya pta yhi mera answer ho
         end=mid-1;
        }
        }
        return ans;
    }
}