class Solution {
     public static int[] searchRange(int[] nums, int target) {

        int[] ans = {-1, -1};
        
        ans[0] = search(nums, target, true);//for finding first first position
        if (ans[0] != -1) {
            ans[1] = search(nums, target, false);//for finding last position
        }
        return ans;
    }

    // this function just returns the index value of target
    static int  search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
           
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                //  ans found  if it it is for finding first position we can serch left again beacuse there can be case that there may first occurrence on its left
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {//or else for finding last we can search to the right agin that it can be there also
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
    
