class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] data=new int[1001];
        for(int[] trip:trips){
            int passengers=trip[0];
            int from=trip[1];
            int to=trip[2];

        data[from]=data[from]+passengers;
        data[to]=data[to]-passengers;
          }
      
        int mycurrent=0;
        for(int i=0;i<1000;i++){
            mycurrent+=data[i];
            if(mycurrent>capacity){
                return false;
            }

        }
        return true;
        
    }
}