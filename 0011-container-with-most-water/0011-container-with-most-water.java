class Solution {
    public int maxArea(int[] height) {
        //bruteforce approach
        // int maxarea=0;
        
        // for(int i=0;i<height.length;i++){
        //     for(int j=i+1;j<height.length;j++){
        //         int width=j-i;
        //         int h=Math.min(height[i],height[j]);
        //         int area=width*h;
        //         maxarea=Math.max(maxarea,area);
        //     }
        // }
        // return maxarea;
        int left=0;int right=height.length-1;
        int res=0;
        while(left<right){
            int water=Math.min(height[left],height[right])*(right-left);
            res=Math.max(res,water);
        
        if(height[left]<height[right])
        {
        left++;
        }
        else
        {
        right--;
        }
        }
        return res;
        
    }
}