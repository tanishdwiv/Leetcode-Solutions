class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int left=0;
        int right=nums.length-1;
        int position=nums.length-1;
        int[] res=new int[nums.length];
        while(left<=right){
            if(Math.abs(nums[left])<Math.abs(nums[right])){
                res[position]=nums[right]*nums[right];
                position--;
                right--;
            }else{
            res[position]=nums[left]*nums[left];
            position--;
            left++;
            }
        }
        return res;
    }
}