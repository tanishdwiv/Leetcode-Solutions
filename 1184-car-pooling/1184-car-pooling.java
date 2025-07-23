class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timeline=new int[1001];
        for(int[] trip:trips){
            int passengers=trip[0];
            int from=trip[1];
            int to=trip[2];

        timeline[from]=timeline[from]+passengers;
        timeline[to]=timeline[to]-passengers;


        }
      
        int mycurrent=0;
        for(int i=0;i<1000;i++){
            mycurrent+=timeline[i];
            if(mycurrent>capacity){
                return false;
            }

        }
        return true;
        
    }
}