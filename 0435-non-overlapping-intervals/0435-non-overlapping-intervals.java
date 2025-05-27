class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        //selecting 1st index and than its end
        int lastend=intervals[0][1];
        int remove=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<lastend){
            remove ++;
            }
            else{
                lastend=intervals[i][1];
            }
        }
        return remove;
    }
}