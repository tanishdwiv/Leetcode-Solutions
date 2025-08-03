class Solution {
    public boolean isPerfectSquare(int num) {
     int s = 0 ; 
     int e = num ;
     while(s <= e) {
        int mid = s + (e-s)/2 ;
            long mids = (long) mid *mid ;
            // this is use becs we need the larger int to find the perfect square
        if(mids == num){
            return true ;
        }
        if(mids > num) {
            e = mid -1 ;
        }
        else{
            s = mid +1 ;
        }

     }
     return false ;   
    
}
}