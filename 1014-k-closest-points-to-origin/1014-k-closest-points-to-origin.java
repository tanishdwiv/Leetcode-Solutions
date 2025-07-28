class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // long x2=0;
        // long y2=0;
        // for(int i=0;i<points.length;i++){
        //     long x1=points[i][0];
        //     long y1=points[i][1];
        //      long sqrt=Math.sqrt(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)));
        // }
        // PriorityQueue<Integer> minheap=new PriorityQueue<>();
        // minheap.offer(sqrt);

        // Sort the entire array using a custom comparator.
        // The comparator calculates the squared Euclidean distance for two points (a and b)
        // and sorts them based on that distance.
        Arrays.sort(points, (a, b) -> 
            (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1])
        );
        
        // Return the first k elements from the sorted array.
        return Arrays.copyOfRange(points, 0, k);

    }
}