class Solution {
    public int[][] kClosest(int[][] points, int k) {
       

        // Sort the entire array using a custom comparator.
        // The comparator calculates the squared Euclidean distance for two points (a and b)
        // and sorts them based on that distance.
        // Arrays.sort(points, (a, b) -> 
        //     (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1])
        // );
        
        // Return the first k elements from the sorted array.
        // return Arrays.copyOfRange(points, 0, k);

//maxheap i have taken as it will store the maximum distance points array from origin 
        PriorityQueue<int[]> maxheap=new PriorityQueue<>((a,b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));

for(int[] point:points){
    maxheap.offer(point);
    //aur hum jbtk maxheap se nikalte rhenge jb tk k points na ho jayen anadar
    if(maxheap.size()>k){
    maxheap.poll();
}
}

int[][] answer=new int[k][2];
for(int i=0;i<k;i++){
    answer[i]=maxheap.poll();
}
return answer;
    }
}