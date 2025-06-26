class Solution {
    public int minTaps(int n, int[] ranges) {
        int furthermost[]=new int[n+1];
        for(int i=0;i<=n;i++){
            int left=Math.max(0,i-ranges[i]);
            int right=i+ranges[i];
            furthermost[left]=Math.max(furthermost[left],right);//this is for tracking maximum distance covered by tap from left position to rightmost what the current tap can reach
        }
        int tapsrequired=0;
        int currentfarthestpoint=0;//to track the tap maximum distance it can cover
        int lasttap=0;//to track the position of the previous tap

        for(int i=0;i<n;i++){//for traversing thr garden
        currentfarthestpoint=Math.max(currentfarthestpoint,furthermost[i]);
        
        if(currentfarthestpoint<=i){
            return -1;  //means there is a gap it cannot covergarden
        }
        if(lasttap==i){
            tapsrequired++;
            lasttap=currentfarthestpoint; //to store the lasttap position to farthest reach possible
        }
        }
        return tapsrequired;
    }
}