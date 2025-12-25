class Solution {
    public int removeDuplicates(int[] nums) {
        int unique=1;//for counting unique elements
        int start=1;//my starting index which will always move
        int position=0;//for findingb the last position where we have to replace
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