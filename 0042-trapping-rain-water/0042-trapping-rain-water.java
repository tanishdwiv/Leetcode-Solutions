class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int maxleft=0;
        int maxright=0;
        int water=0;
        int maxheight=height[0];
        int index=0;
        //for storing index of maximum height among the height array
        //after taking out maximum we will solve left part to height building and from right part to the maximum building
        for(int i=1;i<n;i++){ //finding maximum height here
            if(height[i]>maxheight){
                maxheight=height[i];
                index=i;
            }
        }
        //left part upto maxheight
        for(int i=0;i<index;i++){
            if(maxleft>height[i])
            water+=maxleft-height[i];
            else
            maxleft=height[i];
        }
        //right part 
         for(int i=n-1;i>index;i--){
            if(maxright>height[i])
            water+=maxright-height[i];
            else
            maxright=height[i];
        }
        return water;
        
       

    }
}