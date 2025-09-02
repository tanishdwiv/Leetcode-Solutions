class Solution {
    //we can notice in the question that before single element repeating starts at even index and ends at odd index and after singke element repeating starts at odd index and ends at even index.
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
   
        int low=0;
        int high=n-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(mid%2!=0){
                mid--;
            }
            if(nums[mid]==nums[mid+1]){//we are in normal part and  the left part we ignore it
            low=mid+2;
            }
            else {
                high=mid;
            }  
    }
    return nums[low];
}
}