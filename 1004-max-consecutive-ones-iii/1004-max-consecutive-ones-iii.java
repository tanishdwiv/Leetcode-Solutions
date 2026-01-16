class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0,right=0,max=0,zero=0;
        int n=nums.length;
        while(right<n){// using sliding window
            if(nums[right]==0){
                zero++;//counting zeroes so that it cant take more than two zeroes
            }
            while(zero>k){
                if(nums[left]==0){//if our left pointer reches zero,we will decrease zero count 
                zero--;
                }
                left++;//we will increase until our left reaches zero
            }
            
                max=Math.max(max,right-left+1);
                right++;//we have to increase right pointer always      

        }
        return max;
    }
}  