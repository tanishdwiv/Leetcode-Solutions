class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        // for (int i = 0; i < nums1.length; i++) {
        //     int greaterIdx = -1, j = nums2.length - 1;
        //     while (j >= 0 && nums2[j] != nums1[i]) {
        //         if (nums2[j] > nums1[i]) {
        //             greaterIdx = nums2[j];
        //         }
        //         j--;
        //     }
        //     ans[i] = greaterIdx;
        // }

        // return ans;
        //computing next greater element for num2
        // Stack<Integer> stack=new Stack<>();
        // HashMap<Integer,Integer> ngemp=new HashMap<>();
        // int[] result = new int[nums1.length];
        // for(int num:nums2){
        //     while(!stack.isEmpty() && stack.peek()<num){
        //         ngemp.put(stack.pop(),num);
        //     }
        //     stack.push(num);
        // }

        // for(int i=0;i<nums1.length;i++){
        //  result[i]=ngemp.getOrDefault(nums1[i],-1);
        // }
        // return result;
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums2[i]){
                stack.pop();
            }
            int top=stack.isEmpty()?-1:stack.peek();
            map.put(nums2[i],top);
            stack.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]=map.get(nums1[i]);
        }
        return nums1;

    }
}