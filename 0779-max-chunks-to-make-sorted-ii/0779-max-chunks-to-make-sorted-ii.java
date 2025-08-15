class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int [] minOfRight = new int[n];
        minOfRight[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--) {
            minOfRight[i] = Math.min(minOfRight[i+1], arr[i]);
        }
        int chunk =0;
        int maxfromleft =0;
        for(int i=0; i<n-1; i++) {
            maxfromleft = Math.max(maxfromleft, arr[i]);
            if(maxfromleft <= minOfRight[i+1]) 
            chunk++;
        }
        return chunk+1;
    }
}