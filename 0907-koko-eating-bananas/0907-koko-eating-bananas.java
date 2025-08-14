class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1;
        int max=0;
        for(int ele:piles){
            max=Math.max(max,ele);
        }
        int end=max;
        while(start<=end){
            int mid=start+(end-start)/2;
            long counthours=totalhours(piles,mid);
            if(counthours<=h){
                end=mid-1;//aur chota dekho
            }
            else{
                start=mid+1;
            }
        }
        return start;
        
    }

    long totalhours(int[] piles,int k)
    {
        long hour=0;
        for(int pile:piles){
            hour=hour+(long)Math.ceil((double)pile/k);
        }
        return hour;
}
}