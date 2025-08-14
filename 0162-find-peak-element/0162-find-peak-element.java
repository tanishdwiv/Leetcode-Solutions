class Solution {
    public int findPeakElement(int[] nums) {


  
   
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid+1]) {
                
                end = mid;
            } else {
                // you are in asc part of array
                start = mid + 1; // because we know that mid+1 element > mid element
            }
        }
       
        return end; // or return start as both are =
    }
}

        
    
