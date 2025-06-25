class Solution {
    public int[] nextGreaterElements(int[] nums) {
    //     Stack<Integer> stack=new Stack<>();
    //      int n=nums.length;
    //      int[] result=new int[n];
    //     Arrays.fill(result,-1);
       
    //     for(int i=0;i<2*n;i++){
    //         int num=nums[i%n];
    //         while(!stack.isEmpty() && nums[stack.peek()] < num) {
    //             result[stack.pop()]=num;
    //         }
    //         if(i<n)
    //          stack.push(i%n);
    //     }
    //    return result;

        Stack<Integer> stack=new Stack<>();
         int n=nums.length;
        int[] res=new int[n];
       
        for(int i=2*n-1;i>=0;i--){
            int index=i%n;
            while(!stack.isEmpty() && stack.peek()<=nums[index]){
                stack.pop();
            }if(i<n){
            res[index]=stack.isEmpty()?-1:stack.peek();
            }
            stack.push(nums[index]);
        }
        
        return res;

    }
}