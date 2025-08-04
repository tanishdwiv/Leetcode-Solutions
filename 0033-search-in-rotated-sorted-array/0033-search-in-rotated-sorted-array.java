class Solution {
    public int search(int[] arr, int target) {
        
        int n=arr.length;
        int start=0 ,end=n-1;
        // while(low<=high){
        //     int mid=low+(high-low)/2;
        //     if(nums[mid]==target){
        //         return mid;
        //     }
        //      if (nums[low] == nums[mid]) {
        //         low++;
        //         continue;
        //     }
        //     if(nums[low]<nums[mid]){
        //         if(nums[low]<=target && target<=nums[mid]){
        //             high=mid-1;
        //         }
        //         else{
        //             low=mid+1;
        //         }
        //     }
        //     else{
        //         if(nums[mid]<=target && target<=nums[high]){
        //             low=mid+1;
        //         }
        //         else{
        //             high=mid-1;
        //         }
        //     }

        // }
        // return -1;
    
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
            return mid;
              //left side sorted
            else if(arr[mid]>=arr[start]){
                if(arr[start]<=target && target<=arr[mid])
               end=mid-1;
                else
               start=mid+1;
            }
            else//going to right sorted pART
            {
                if(arr[mid]<=target && target<=arr[end])
                start=mid+1;
                else
               end=mid-1;
            }
        }
        return -1;
    }
}