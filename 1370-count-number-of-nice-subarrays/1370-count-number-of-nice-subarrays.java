class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
  
        return solve(nums,k)-solve(nums,k-1);  
    }
    int solve(int[] nums,int k){
        int n=nums.length-1;
        int countodd=0;
        int result=0;//for counting subarrays
        int left=0;
        for(int right=0;right<=n;right++){
            if(nums[right]%2!=0){
                countodd++;
            }
            while(countodd>k){
                if(nums[left]%2!=0){
                    countodd--;
                }
                left++;
            }
            result+=(right-left+1);
        }
        
        return result;
    }
}