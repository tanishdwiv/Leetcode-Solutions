class Solution {
    public int removeDuplicates(int[] nums) {
        int unique=1;
        int start=1;
        int position=0;
        int n=nums.length;
        while(start<n){
        if(nums[start]==nums[start-1]){
            start++;
            continue;
        }
        
        nums[position+1]=nums[start];
        unique++;
        position++;
        
        start++;
        }
        
        return unique;
        
    }
}