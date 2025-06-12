class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points,(a,b)->(a[1]<=b[1])?-1:1);//comparator to sort on basis of end index
        int arrow=1;
        int lastend=points[0][1];
        for(int point[]:points){
            if(point[0]>lastend){
                arrow++;
                lastend=point[1];
            }
        }
        return arrow;
    }
}