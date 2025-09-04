class Solution {
    public int specialArray(int[] nums) {
     int start=0;
     int end=nums.length;
     while(start<=end){
        int mid=start+(end-start)/2;
        int count=counts(nums,mid);
        if(count==mid){
            return mid;  //this is my special number
        }
        else if(count>mid){ //count is greater than my special x and my x is too low so i should increse it
        start=mid+1;
        }
     
     else { 
        end=mid-1;
     }
     }
     return -1;
    }
        
    
    
    public int counts(int[] nums,int x){
        int coun=0;
        for(int i:nums){
            if(i>=x)//i will count how many numbers are greater than x 
            {
             coun++;
            }
        }
        return coun;
    }
}