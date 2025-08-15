class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int[] minsuffixfromright=new int[n];
        minsuffixfromright[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            minsuffixfromright[i]=Math.min(minsuffixfromright[i+1],arr[i]);
        }
        int chunks=0;
        int maxfromleft=0;
        for(int i=0;i<n-1;i++){
            maxfromleft=Math.max(maxfromleft,arr[i]);
            if(maxfromleft<=minsuffixfromright[i+1]){
                chunks++;
            }
        }

    return chunks+1;
            
        
    }
}