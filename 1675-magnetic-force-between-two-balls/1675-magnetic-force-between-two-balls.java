class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length;
        int start=1;
        int end=position[n-1]-position[0];
        int ans=0;
        while(start<=end){
            int mid=(start+end)/2;
            if(isAllocationpossible(position,m,mid)){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
        
    }

    boolean isAllocationpossible(int[] position,int m,int mindist){
        int ballplaced=1;
        int lastplaced=position[0];
        for(int i=1;i<position.length;i++){
            if(position[i]-lastplaced>=mindist){
                ballplaced++;
                lastplaced=position[i];
            }
            if(ballplaced>=m)
            return true;

        }
        return false;
    }
}