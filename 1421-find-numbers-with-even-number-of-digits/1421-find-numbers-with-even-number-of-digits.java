class Solution {
    public int findNumbers(int[] nums) {


        int  total_num=0;
        
       for(int i= 0; i<nums.length;i++){
          int digit_count= (String.valueOf(nums[i])).length(); 
          if(digit_count % 2 == 0 ){
            total_num++;
          }
       }
       return total_num;
    }
}