class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //i am applying binary search on answer
        int w=weights.length;
        int start=0;
        int end=0;
        for(int i=0;i<w;i++){
           start=Math.max(start,weights[i]);
           end=end+weights[i];
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            if(noofdaysrequired(weights,mid)<=days){
                end=mid-1;   //agar possible h toh aur chota dekho
            }
            else{
               start=mid+1;
            }
        }
        return start;
    }

    int noofdaysrequired(int[] weights,int capacity){
        int load=0;
       int noofdays=1;
        for(int i=0;i<weights.length;i++){
        if(load+weights[i]>capacity){
            noofdays++;
            load=weights[i];
        }
        else{
            load=load+weights[i];
        }
        }
        return noofdays;
    }
}