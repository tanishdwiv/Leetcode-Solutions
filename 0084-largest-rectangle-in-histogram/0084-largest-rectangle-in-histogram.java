class Solution {
    public int largestRectangleArea(int[] heights) {
        int h=heights.length;
        int[] right=new int[h+1];
        int[] left=new int[h+1];
        Stack<Integer> stack=new Stack<>();
        

        //right smaller similar to next graeter but here it is next smaller
        for(int i=h-1;i>=0;i--){
            while(stack.size()>0 && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            right[i]=stack.isEmpty()?h:stack.peek();//instead of -1 we will take last boundary because -1 will give us wrong answer
            stack.push(i);
        }
        //stack khali krna pdega left smaller se pehle
        while(!stack.isEmpty()){
            stack.pop();
        }

        //left smaller similar to previous greater
         for(int i=0;i<h;i++){
            while(stack.size()>0 && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            left[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
          int ans=0;
        for(int i=0;i<h;i++){
           int width=right[i]-left[i]-1;
           int  currentarea=heights[i]*width;
           ans=Math.max(ans,currentarea);
        }

      return ans;
    }
}