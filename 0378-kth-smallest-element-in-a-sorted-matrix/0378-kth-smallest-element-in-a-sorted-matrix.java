class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int num=matrix[i][j];
                maxheap.add(num);
            }
        }
        while(maxheap.size()>k){
            maxheap.poll();
        }
        return maxheap.peek();
        
    }
}