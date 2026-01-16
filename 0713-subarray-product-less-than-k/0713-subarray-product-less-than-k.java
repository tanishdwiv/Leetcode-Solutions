class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int pro=1,res=0,start=0,end=0;
        int n=nums.length;
        int count=0;
        // while(j<n){
        //     pro=pro*nums[j];
        //     while(i<=j && pro>=k){
        //         pro=pro/nums[i];
        //         i++;
        //     }
           
        //         int len=j-i+1;
        //         res=res+len;
        //         j++;
            
        // }
        // return res;
        for( end=0;end<n;end++){
            pro=pro*nums[end];

            //here i am shrinking the window if product is greater than k
            while(start<=end && pro>=k){
                pro=pro/nums[start];
                start++;
            }
            count+=end-start+1;
        }
        return count;
    }
}