class Solution {
    public int findMin(int[] nums) {
        int ans=nums[0];
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[0]){
                start=mid+1;
            }
            else if(nums[mid]<nums[0]) {
                ans=nums[mid];
                end=mid-1;
            }
            else{
                ans=Math.min(ans,nums[end]);
                end--;
            }
        }
        return ans;
    }
}